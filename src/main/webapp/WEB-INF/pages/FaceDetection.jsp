<%@ include file="header.jsp" %>
   <html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="chrome=1">
		<title></title>
		
		<script>
		/*
		This code was taken from https://github.com/cbrandolino/camvas and modified to suit our needs
	*/
	/*
	Copyright (c) 2012 Claudio Brandolino

	Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
	*/
	// The function takes a canvas context and a `drawFunc` function.
	// `drawFunc` receives two parameters, the video and the time since
	// the last time it was called.
	function camvas(ctx, callback) {
	  var self = this
	  this.ctx = ctx
	  this.callback = callback

	  // We can't `new Video()` yet, so we'll resort to the vintage
	  // "hidden div" hack for dynamic loading.
	  var streamContainer = document.createElement('div')
	  this.video = document.createElement('video')

	  // If we don't do this, the stream will not be played.
	  // By the way, the play and pause controls work as usual 
	  // for streamed videos.
	  this.video.setAttribute('autoplay', '1')
	  this.video.setAttribute('playsinline', '1') // important for iPhones

	  // The video should fill out all of the canvas
	  this.video.setAttribute('width', 1)
	  this.video.setAttribute('height', 1)

	  streamContainer.appendChild(this.video)
	  document.body.appendChild(streamContainer)

	  // The callback happens when we are starting to stream the video.
	  navigator.mediaDevices.getUserMedia({video: true, audio: false}).then(function(stream) {
	    // Yay, now our webcam input is treated as a normal video and
	    // we can start having fun
	    self.video.srcObject = stream
	    // Let's start drawing the canvas!
	    self.update()
	  }, function(err) {
	    throw err
	  })

	  // As soon as we can draw a new frame on the canvas, we call the `draw` function 
	  // we passed as a parameter.
	  this.update = function() {
		var self = this
	    var last = Date.now()
	    var loop = function() {
	      // For some effects, you might want to know how much time is passed
	      // since the last frame; that's why we pass along a Delta time `dt`
	      // variable (expressed in milliseconds)
	      var dt = Date.now() - last
	      self.callback(self.video, dt)
	      last = Date.now()
	      requestAnimationFrame(loop) 
	    }
	    requestAnimationFrame(loop) 
	  } 
	}

		</script>
		<!-- ******************************** pico.js************************************ -->
		<script>
		/* This library is released under the MIT license, see https://github.com/tehnokv/picojs */
		pico = {}

		pico.unpack_cascade = function(bytes)
		{
			//
			const dview = new DataView(new ArrayBuffer(4));
			/*
				we skip the first 8 bytes of the cascade file
				(cascade version number and some data used during the learning process)
			*/
			let p = 8;
			/*
				read the depth (size) of each tree first: a 32-bit signed integer
			*/
			dview.setUint8(0, bytes[p+0]), dview.setUint8(1, bytes[p+1]), dview.setUint8(2, bytes[p+2]), dview.setUint8(3, bytes[p+3]);
			const tdepth = dview.getInt32(0, true);
			p = p + 4
			/*
				next, read the number of trees in the cascade: another 32-bit signed integer
			*/
			dview.setUint8(0, bytes[p+0]), dview.setUint8(1, bytes[p+1]), dview.setUint8(2, bytes[p+2]), dview.setUint8(3, bytes[p+3]);
			const ntrees = dview.getInt32(0, true);
			p = p + 4
			/*
				read the actual trees and cascade thresholds
			*/
			const tcodes_ls = [];
			const tpreds_ls = [];
			const thresh_ls = [];
			for(let t=0; t<ntrees; ++t)
			{
				// read the binary tests placed in internal tree nodes
				Array.prototype.push.apply(tcodes_ls, [0, 0, 0, 0]);
				Array.prototype.push.apply(tcodes_ls, bytes.slice(p, p+4*Math.pow(2, tdepth)-4));
				p = p + 4*Math.pow(2, tdepth)-4;
				// read the prediction in the leaf nodes of the tree
				for(let i=0; i<Math.pow(2, tdepth); ++i)
				{
					dview.setUint8(0, bytes[p+0]), dview.setUint8(1, bytes[p+1]), dview.setUint8(2, bytes[p+2]), dview.setUint8(3, bytes[p+3]);
					tpreds_ls.push(dview.getFloat32(0, true));
					p = p + 4;
				}
				// read the threshold
				dview.setUint8(0, bytes[p+0]), dview.setUint8(1, bytes[p+1]), dview.setUint8(2, bytes[p+2]), dview.setUint8(3, bytes[p+3]);
				thresh_ls.push(dview.getFloat32(0, true));
				p = p + 4;
			}
			const tcodes = new Int8Array(tcodes_ls);
			const tpreds = new Float32Array(tpreds_ls);
			const thresh = new Float32Array(thresh_ls);
			/*
				construct the classification function from the read data
			*/
			function classify_region(r, c, s, pixels, ldim)
			{
				 r = 256*r;
				 c = 256*c;
				 let root = 0;
				 let o = 0.0;
				 const pow2tdepth = Math.pow(2, tdepth) >> 0; // '>>0' transforms this number to int

				 for(let i=0; i<ntrees; ++i)
				 {
					idx = 1;
					for(let j=0; j<tdepth; ++j)
						// we use '>> 8' here to perform an integer division: this seems important for performance
						idx = 2*idx + (pixels[((r+tcodes[root + 4*idx + 0]*s) >> 8)*ldim+((c+tcodes[root + 4*idx + 1]*s) >> 8)]<=pixels[((r+tcodes[root + 4*idx + 2]*s) >> 8)*ldim+((c+tcodes[root + 4*idx + 3]*s) >> 8)]);

					 o = o + tpreds[pow2tdepth*i + idx-pow2tdepth];

					 if(o<=thresh[i])
						 return -1;

					 root += 4*pow2tdepth;
				}
				return o - thresh[ntrees-1];
			}
			/*
				we're done
			*/
			return classify_region;
		}

		pico.run_cascade = function(image, classify_region, params)
		{
			const pixels = image.pixels;
			const nrows = image.nrows;
			const ncols = image.ncols;
			const ldim = image.ldim;

			const shiftfactor = params.shiftfactor;
			const minsize = params.minsize;
			const maxsize = params.maxsize;
			const scalefactor = params.scalefactor;

			let scale = minsize;
			const detections = [];

			while(scale<=maxsize)
			{
				const step = Math.max(shiftfactor*scale, 1) >> 0; // '>>0' transforms this number to int
				const offset = (scale/2 + 1) >> 0;

				for(let r=offset; r<=nrows-offset; r+=step)
					for(let c=offset; c<=ncols-offset; c+=step)
					{
						const q = classify_region(r, c, scale, pixels, ldim);
						if (q > 0.0)
							detections.push([r, c, scale, q]);
					}
				
				scale = scale*scalefactor;
			}

		    return detections;
		}

		pico.cluster_detections = function(dets, iouthreshold)
		{
			/*
				sort detections by their score
			*/
			dets = dets.sort(function(a, b) {
				return b[3] - a[3];
			});
			/*
				this helper function calculates the intersection over union for two detections
			*/
			function calculate_iou(det1, det2)
			{
				// unpack the position and size of each detection
				const r1=det1[0], c1=det1[1], s1=det1[2];
				const r2=det2[0], c2=det2[1], s2=det2[2];
				// calculate detection overlap in each dimension
				const overr = Math.max(0, Math.min(r1+s1/2, r2+s2/2) - Math.max(r1-s1/2, r2-s2/2));
				const overc = Math.max(0, Math.min(c1+s1/2, c2+s2/2) - Math.max(c1-s1/2, c2-s2/2));
				// calculate and return IoU
				return overr*overc/(s1*s1+s2*s2-overr*overc);
			}
			/*
				do clustering through non-maximum suppression
			*/
			const assignments = new Array(dets.length).fill(0);
			const clusters = [];
			for(let i=0; i<dets.length; ++i)
			{
				// is this detection assigned to a cluster?
				if(assignments[i]==0)
				{
					// it is not:
					// now we make a cluster out of it and see whether some other detections belong to it
					let r=0.0, c=0.0, s=0.0, q=0.0, n=0;
					for(let j=i; j<dets.length; ++j)
						if(calculate_iou(dets[i], dets[j])>iouthreshold)
						{
							assignments[j] = 1;
							r = r + dets[j][0];
							c = c + dets[j][1];
							s = s + dets[j][2];
							q = q + dets[j][3];
							n = n + 1;
						}
					// make a cluster representative
					clusters.push([r/n, c/n, s/n, q]);
				}
			}

			return clusters;
		}

		pico.instantiate_detection_memory = function(size)
		{
			/*
				initialize a circular buffer of `size` elements
			*/
			let n = 0;
			const memory = [];
			for(let i=0; i<size; ++i)
				memory.push([]);
			/*
				build a function that:
				(1) inserts the current frame's detections into the buffer;
				(2) merges all detections from the last `size` frames and returns them
			*/
			function update_memory(dets)
			{
				memory[n] = dets;
				n = (n+1)%memory.length;
				dets = [];
				for(i=0; i<memory.length; ++i)
					dets = dets.concat(memory[i]);
				//
				return dets;
			}
			/*
				we're done
			*/
			return update_memory;
		}
		</script>
	<!-- 	*******************************lploc.js************************************ -->
		<script>
		/* This library is released under the MIT license, contact @tehnokv for more details */
		lploc = {}

		lploc.unpack_localizer = function(bytes)
		{
			//
			const dview = new DataView(new ArrayBuffer(4));
			let p = 0;
			/*
				read the number of stages, scale multiplier (applied after each stage),
				number of trees per stage and depth of each tree
			*/
			dview.setUint8(0, bytes[p+0]), dview.setUint8(1, bytes[p+1]), dview.setUint8(2, bytes[p+2]), dview.setUint8(3, bytes[p+3]);
			const nstages = dview.getInt32(0, true);
			p = p + 4;
			dview.setUint8(0, bytes[p+0]), dview.setUint8(1, bytes[p+1]), dview.setUint8(2, bytes[p+2]), dview.setUint8(3, bytes[p+3]);
			const scalemul = dview.getFloat32(0, true);
			p = p + 4;
			dview.setUint8(0, bytes[p+0]), dview.setUint8(1, bytes[p+1]), dview.setUint8(2, bytes[p+2]), dview.setUint8(3, bytes[p+3]);
			const ntreesperstage = dview.getInt32(0, true);
			p = p + 4;
			dview.setUint8(0, bytes[p+0]), dview.setUint8(1, bytes[p+1]), dview.setUint8(2, bytes[p+2]), dview.setUint8(3, bytes[p+3]);
			const tdepth = dview.getInt32(0, true);
			p = p + 4;
			/*
				unpack the trees
			*/
			const tcodes_ls = [];
			const tpreds_ls = [];
			for(let i=0; i<nstages; ++i)
			{
				// read the trees for this stage
				for(let j=0; j<ntreesperstage; ++j)
				{
					// binary tests (we can read all of them at once)
					Array.prototype.push.apply(tcodes_ls, bytes.slice(p, p+4*Math.pow(2, tdepth)-4));
					p = p + 4*Math.pow(2, tdepth)-4;
					// read the prediction in the leaf nodes of the tree
					for(let k=0; k<Math.pow(2, tdepth); ++k)
						for(let l=0; l<2; ++l)
						{
							dview.setUint8(0, bytes[p+0]), dview.setUint8(1, bytes[p+1]), dview.setUint8(2, bytes[p+2]), dview.setUint8(3, bytes[p+3]);
							tpreds_ls.push(dview.getFloat32(0, true));
							p = p + 4;
						}
				}
			}
			const tcodes = new Int8Array(tcodes_ls);
			const tpreds = new Float32Array(tpreds_ls);
			/*
				construct the location estimaton function
			*/
			function loc_fun(r, c, s, pixels, nrows, ncols, ldim)
			{
				let root = 0;
				const pow2tdepth = Math.pow(2, tdepth) >> 0; // '>>0' transforms this number to int

				for(let i=0; i<nstages; ++i)
				{
					let dr=0.0, dc=0.0;

					for(let j=0; j<ntreesperstage; ++j)
					{
						let idx = 0;
						for(var k=0; k<tdepth; ++k)
						{
							const r1 = Math.min(nrows-1, Math.max(0, (256*r+tcodes[root + 4*idx + 0]*s)>>8));
							const c1 = Math.min(ncols-1, Math.max(0, (256*c+tcodes[root + 4*idx + 1]*s)>>8));
							const r2 = Math.min(nrows-1, Math.max(0, (256*r+tcodes[root + 4*idx + 2]*s)>>8));
							const c2 = Math.min(ncols-1, Math.max(0, (256*c+tcodes[root + 4*idx + 3]*s)>>8));

							idx = 2*idx + 1 + (pixels[r1*ldim+c1] > pixels[r2*ldim+c2])
						}

						const lutidx = 2*(ntreesperstage*pow2tdepth*i + pow2tdepth*j + idx - (pow2tdepth - 1))
						dr += tpreds[lutidx + 0];
						dc += tpreds[lutidx + 1];

						root += 4*pow2tdepth - 4;
					}

					r = r + dr*s;
					c = c + dc*s;

					s = s*scalemul;
				}

				return [r, c];
			}
			/*
				this function applies random perturbations to the default rectangle (r, c, s)
			*/
			function loc_fun_with_perturbs(r, c, s, nperturbs, image)
			{
				const rows=[], cols=[];

				for(let i=0; i<nperturbs; ++i)
				{
					const _s = s*(0.925 + 0.15*Math.random());
					let _r = r + s*0.15*(0.5 - Math.random());
					let _c = c + s*0.15*(0.5 - Math.random());

					[_r, _c] = loc_fun(_r, _c, _s, image.pixels, image.nrows, image.ncols, image.ldim)

					rows.push(_r)
					cols.push(_c)
				}

				// return the median along each axis
				rows.sort()
				cols.sort()

				return [rows[Math.rectanlge(nperturbs/2)], cols[Math.rectanlge(nperturbs/2)]];
			}
			/*
				we're done
			*/
			return loc_fun_with_perturbs;
		}
		
		</script>
	</head>
	<script>
	$(document).ready(function() {
		button_callback();
		
	});
	</script>
	<script>
		var initialized = false;
		function button_callback() {
			/*
				(0) check whether we're already running face detection
			*/
			if(initialized)
				return; // if yes, then do not initialize everything again
			/*
				(1) initialize the pico.js face detector
			*/
			var update_memory = pico.instantiate_detection_memory(5); // we will use the detecions of the last 5 frames
			var facefinder_classify_region = function(r, c, s, pixels, ldim) {return -1.0;};
			var cascadeurl = 'https://raw.githubusercontent.com/nenadmarkus/pico/c2e81f9d23cc11d1a612fd21e4f9de0921a5d0d9/rnt/cascades/facefinder';
			fetch(cascadeurl).then(function(response) {
				response.arrayBuffer().then(function(buffer) {
					var bytes = new Int8Array(buffer);
					facefinder_classify_region = pico.unpack_cascade(bytes);
					console.log('* facefinder loaded');
				})
			})
			/*
				(2) initialize the lploc.js library with a pupil localizer
			*/
			var do_puploc = function(r, c, s, nperturbs, pixels, nrows, ncols, ldim) {return [-1.0, -1.0];};
			//var puplocurl = '../puploc.bin';
			var puplocurl = 'https://f002.backblazeb2.com/file/tehnokv-www/posts/puploc-with-trees/demo/puploc.bin'
			fetch(puplocurl).then(function(response) {
				response.arrayBuffer().then(function(buffer) {
					var bytes = new Int8Array(buffer);
					do_puploc = lploc.unpack_localizer(bytes);
					console.log('* puploc loaded');
				})
			})
			/*
				(3) get the drawing context on the canvas and define a function to transform an RGBA image to grayscale
			*/
			var ctx = document.getElementsByTagName('canvas')[0].getContext('2d');
			function rgba_to_grayscale(rgba, nrows, ncols) {
				var gray = new Uint8Array(nrows*ncols);
				for(var r=0; r<nrows; ++r)
					for(var c=0; c<ncols; ++c)
						// gray = 0.2*red + 0.7*green + 0.1*blue
						gray[r*ncols + c] = (2*rgba[r*4*ncols+4*c+0]+7*rgba[r*4*ncols+4*c+1]+1*rgba[r*4*ncols+4*c+2])/10;
				return gray;
			}
			/*
				(4) this function is called each time a video frame becomes available
			*/
			var processfn = function(video, dt) {
				// render the video frame to the canvas element and extract RGBA pixel data
				ctx.drawImage(video, 0, 0);
				var rgba = ctx.getImageData(0, 0, 640, 480).data;
				// prepare input to `run_cascade`
				image = {
					"pixels": rgba_to_grayscale(rgba, 480, 640),
					"nrows": 480,
					"ncols": 640,
					"ldim": 640
				}
				params = {
					"shiftfactor": 0.1, // move the detection window by 10% of its size
					"minsize": 100,     // minimum size of a face
					"maxsize": 1000,    // maximum size of a face
					"scalefactor": 1.1  // for multiscale processing: resize the detection window by 10% when moving to the higher scale
				}
				// run the cascade over the frame and cluster the obtained detections
				// dets is an array that contains (r, c, s, q) quadruplets
				// (representing row, column, scale and detection score)
				dets = pico.run_cascade(image, facefinder_classify_region, params);
				dets = update_memory(dets);
				dets = pico.cluster_detections(dets, 0.2); // set IoU threshold to 0.2
				// draw detections
				for(i=0; i<dets.length; ++i)
					// check the detection score
					// if it's above the threshold, draw it
					// (the constant 50.0 is empirical: other cascades might require a different one)
					if(dets[i][3]>50.0)
					{
						var r, c, s;
						//
						ctx.beginPath();
						ctx.arc(dets[i][1], dets[i][0], dets[i][2]/2, 0, 2*Math.PI, false);
						ctx.lineWidth = 3;
						ctx.strokeStyle = 'none';
						ctx.stroke();
						//
						// find the eye pupils for each detected face
						// starting regions for localization are initialized based on the face bounding box
						// (parameters are set empirically)
						// first eye
						r = dets[i][0] - 0.075*dets[i][2];
						c = dets[i][1] - 0.175*dets[i][2];
						s = 0.35*dets[i][2];
						[r, c] = do_puploc(r, c, s, 63, image)
						if(r>=0 && c>=0)
						{
							ctx.beginPath();
							ctx.arc(c, r, 1, 0, 2*Math.PI, false);
							ctx.lineWidth = 3;
							ctx.strokeStyle = 'none';
							ctx.stroke();
						}
						// second eye
						r = dets[i][0] - 0.075*dets[i][2];
						c = dets[i][1] + 0.175*dets[i][2];
						s = 0.35*dets[i][2];
						[r, c] = do_puploc(r, c, s, 63, image)
						if(r>=0 && c>=0)
						{
							ctx.beginPath();
							ctx.arc(c, r, 1, 0, 2*Math.PI, false);
							ctx.lineWidth = 3;
							ctx.strokeStyle = 'none';
							ctx.stroke();
						}
					}
			}
			/*
				(5) instantiate camera handling (see https://github.com/cbrandolino/camvas)
			*/
			var mycamvas = new camvas(ctx, processfn);
			/*
				(6) it seems that everything went well
			*/
			initialized = true;
		}
		/*  document.getElementById('pre_take_buttons').style.display = '';
		document.getElementById('post_take_buttons').style.display = 'none'; */ 
		
	</script>
	
			
	<body>
	
	
		<p align="center"><canvas id="canvas" class="rounded-circle"  width=275 height=275></canvas></p>
		<div align="center">
		<button type="Reset" onclick="window.location.reload()">Cancel</button>
		<button type="submit" onclick="Canvas()">Save</button>
		</div>
		</body>
		<script>
		
		function Canvas(){
			alert(">>>>")
			 var canvas = document.getElementById('canvas');
			// alert(">>>>"+canvas);
			  var dataURL = canvas.toDataURL();
			  alert("dataURL>>>"+dataURL);
			  var canvas = dataURItoBlob(dataURL);
			  var formdata = new FormData();
			  formdata.append("canvas", canvas);
			  $.ajax({
					type : "post",
					url : "LoginPhoto", // this controller url
					data:formdata, 
					processData : false,
					contentType : false,
					success : function(data) {
						/* $("#successmessage").html(" Sucessfully Stored");
						setInterval(function() {
							window.location.reload(); // this will run after every 5 seconds
						}, 2000); */
						alert("YES ")

					}
			
				});
		}

		function dataURItoBlob(dataURI) {
			//alert(">>>>>>>")
		// convert base64/URLEncoded data component to raw binary data held in a string
		var byteString;
		if (dataURI.split(',')[0].indexOf('base64') >= 0)
		    byteString = atob(dataURI.split(',')[1]);
		else
		    byteString = unescape(dataURI.split(',')[1]);
		// separate out the mime component
		var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];
		// write the bytes of the string to a typed array
		var ia = new Uint8Array(byteString.length);
		for (var i = 0; i < byteString.length; i++) {
		    ia[i] = byteString.charCodeAt(i);
		}
		return new Blob([ia], {type:mimeString});
		}
		
		 
		</script>
		
</html>   

 <!--  <!doctype html>

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>WebcamJS Test Page</title>
	<style type="text/css">
		body { font-family: Helvetica, sans-serif; }
		h1, h2, h3 { margin-top:0; margin-bottom:0; }
		form { margin-top: 15px; }
		form input { margin-right: 15px; }
		#results { display:inline-block; margin:20px; padding:20px; border:1px solid; background:#ccc; }
	</style>
</head>
<body>
	

	
	<div id="my_photo_booth" align="center">
		<div id="my_camera"  class="rounded-circle"  width=275 height=275 ></div>
		
		First, include the Webcam.js JavaScript Library
		<script>
		
		// WebcamJS v1.0.25 - http://github.com/jhuckaby/webcamjs - MIT Licensed
		(function(e){var t;function a(){var e=Error.apply(this,arguments);e.name=this.name="FlashError";this.stack=e.stack;this.message=e.message}function i(){var e=Error.apply(this,arguments);e.name=this.name="WebcamError";this.stack=e.stack;this.message=e.message}var s=function(){};s.prototype=Error.prototype;a.prototype=new s;i.prototype=new s;var Webcam={version:"1.0.26",protocol:location.protocol.match(/https/i)?"https":"http",loaded:false,live:false,userMedia:true,iOS:/iPad|iPhone|iPod/.test(navigator.userAgent)&&!e.MSStream,params:{width:0,height:0,dest_width:0,dest_height:0,image_format:"jpeg",jpeg_quality:90,enable_flash:true,force_flash:false,flip_horiz:false,fps:30,upload_name:"webcam",constraints:null,swfURL:"",flashNotDetectedText:"ERROR: No Adobe Flash Player detected.  Webcam.js relies on Flash for browsers that do not support getUserMedia (like yours).",noInterfaceFoundText:"No supported webcam interface found.",unfreeze_snap:true,iosPlaceholderText:"Click here to open camera.",user_callback:null,user_canvas:null},errors:{FlashError:a,WebcamError:i},hooks:{},init:function(){var t=this;this.mediaDevices=navigator.mediaDevices&&navigator.mediaDevices.getUserMedia?navigator.mediaDevices:navigator.mozGetUserMedia||navigator.webkitGetUserMedia?{getUserMedia:function(e){return new Promise(function(t,a){(navigator.mozGetUserMedia||navigator.webkitGetUserMedia).call(navigator,e,t,a)})}}:null;e.URL=e.URL||e.webkitURL||e.mozURL||e.msURL;this.userMedia=this.userMedia&&!!this.mediaDevices&&!!e.URL;if(navigator.userAgent.match(/Firefox\D+(\d+)/)){if(parseInt(RegExp.$1,10)<21)this.userMedia=null}if(this.userMedia){e.addEventListener("beforeunload",function(e){t.reset()})}},exifOrientation:function(e){var t=new DataView(e);if(t.getUint8(0)!=255||t.getUint8(1)!=216){console.log("Not a valid JPEG file");return 0}var a=2;var i=null;while(a<e.byteLength){if(t.getUint8(a)!=255){console.log("Not a valid marker at offset "+a+", found: "+t.getUint8(a));return 0}i=t.getUint8(a+1);if(i==225){a+=4;var s="";for(n=0;n<4;n++){s+=String.fromCharCode(t.getUint8(a+n))}if(s!="Exif"){console.log("Not valid EXIF data found");return 0}a+=6;var r=null;if(t.getUint16(a)==18761){r=false}else if(t.getUint16(a)==19789){r=true}else{console.log("Not valid TIFF data! (no 0x4949 or 0x4D4D)");return 0}if(t.getUint16(a+2,!r)!=42){console.log("Not valid TIFF data! (no 0x002A)");return 0}var o=t.getUint32(a+4,!r);if(o<8){console.log("Not valid TIFF data! (First offset less than 8)",t.getUint32(a+4,!r));return 0}var l=a+o;var h=t.getUint16(l,!r);for(var c=0;c<h;c++){var d=l+c*12+2;if(t.getUint16(d,!r)==274){var f=t.getUint16(d+2,!r);var m=t.getUint32(d+4,!r);if(f!=3&&m!=1){console.log("Invalid EXIF orientation value type ("+f+") or count ("+m+")");return 0}var p=t.getUint16(d+8,!r);if(p<1||p>8){console.log("Invalid EXIF orientation value ("+p+")");return 0}return p}}}else{a+=2+t.getUint16(a+2)}}return 0},fixOrientation:function(e,t,a){var i=new Image;i.addEventListener("load",function(e){var s=document.createElement("canvas");var r=s.getContext("2d");if(t<5){s.width=i.width;s.height=i.height}else{s.width=i.height;s.height=i.width}switch(t){case 2:r.transform(-1,0,0,1,i.width,0);break;case 3:r.transform(-1,0,0,-1,i.width,i.height);break;case 4:r.transform(1,0,0,-1,0,i.height);break;case 5:r.transform(0,1,1,0,0,0);break;case 6:r.transform(0,1,-1,0,i.height,0);break;case 7:r.transform(0,-1,-1,0,i.height,i.width);break;case 8:r.transform(0,-1,1,0,0,i.width);break}r.drawImage(i,0,0);a.src=s.toDataURL()},false);i.src=e},attach:function(a){if(typeof a=="string"){a=document.getElementById(a)||document.querySelector(a)}if(!a){return this.dispatch("error",new i("Could not locate DOM element to attach to."))}this.container=a;a.innerHTML="";var s=document.createElement("div");a.appendChild(s);this.peg=s;if(!this.params.width)this.params.width=a.offsetWidth;if(!this.params.height)this.params.height=a.offsetHeight;if(!this.params.width||!this.params.height){return this.dispatch("error",new i("No width and/or height for webcam.  Please call set() first, or attach to a visible element."))}if(!this.params.dest_width)this.params.dest_width=this.params.width;if(!this.params.dest_height)this.params.dest_height=this.params.height;this.userMedia=t===undefined?this.userMedia:t;if(this.params.force_flash){t=this.userMedia;this.userMedia=null}if(typeof this.params.fps!=="number")this.params.fps=30;var r=this.params.width/this.params.dest_width;var o=this.params.height/this.params.dest_height;if(this.userMedia){var n=document.createElement("video");n.setAttribute("autoplay","autoplay");n.setAttribute("playsinline","playsinline");n.style.width=""+this.params.dest_width+"px";n.style.height=""+this.params.dest_height+"px";if(r!=1||o!=1){a.style.overflow="hidden";n.style.webkitTransformOrigin="0px 0px";n.style.mozTransformOrigin="0px 0px";n.style.msTransformOrigin="0px 0px";n.style.oTransformOrigin="0px 0px";n.style.transformOrigin="0px 0px";n.style.webkitTransform="scaleX("+r+") scaleY("+o+")";n.style.mozTransform="scaleX("+r+") scaleY("+o+")";n.style.msTransform="scaleX("+r+") scaleY("+o+")";n.style.oTransform="scaleX("+r+") scaleY("+o+")";n.style.transform="scaleX("+r+") scaleY("+o+")"}a.appendChild(n);this.video=n;var l=this;this.mediaDevices.getUserMedia({audio:false,video:this.params.constraints||{mandatory:{minWidth:this.params.dest_width,minHeight:this.params.dest_height}}}).then(function(t){n.onloadedmetadata=function(e){l.stream=t;l.loaded=true;l.live=true;l.dispatch("load");l.dispatch("live");l.flip()};if("srcObject"in n){n.srcObject=t}else{n.src=e.URL.createObjectURL(t)}}).catch(function(e){if(l.params.enable_flash&&l.detectFlash()){setTimeout(function(){l.params.force_flash=1;l.attach(a)},1)}else{l.dispatch("error",e)}})}else if(this.iOS){var h=document.createElement("div");h.id=this.container.id+"-ios_div";h.className="webcamjs-ios-placeholder";h.style.width=""+this.params.width+"px";h.style.height=""+this.params.height+"px";h.style.textAlign="center";h.style.display="table-cell";h.style.verticalAlign="middle";h.style.backgroundRepeat="no-repeat";h.style.backgroundSize="contain";h.style.backgroundPosition="center";var c=document.createElement("span");c.className="webcamjs-ios-text";c.innerHTML=this.params.iosPlaceholderText;h.appendChild(c);var d=document.createElement("img");d.id=this.container.id+"-ios_img";d.style.width=""+this.params.dest_width+"px";d.style.height=""+this.params.dest_height+"px";d.style.display="none";h.appendChild(d);var f=document.createElement("input");f.id=this.container.id+"-ios_input";f.setAttribute("type","file");f.setAttribute("accept","image/*");f.setAttribute("capture","camera");var l=this;var m=this.params;f.addEventListener("change",function(e){if(e.target.files.length>0&&e.target.files[0].type.indexOf("image/")==0){var t=URL.createObjectURL(e.target.files[0]);var a=new Image;a.addEventListener("load",function(e){var t=document.createElement("canvas");t.width=m.dest_width;t.height=m.dest_height;var i=t.getContext("2d");ratio=Math.min(a.width/m.dest_width,a.height/m.dest_height);var s=m.dest_width*ratio;var r=m.dest_height*ratio;var o=(a.width-s)/2;var n=(a.height-r)/2;i.drawImage(a,o,n,s,r,0,0,m.dest_width,m.dest_height);var l=t.toDataURL();d.src=l;h.style.backgroundImage="url('"+l+"')"},false);var i=new FileReader;i.addEventListener("load",function(e){var i=l.exifOrientation(e.target.result);if(i>1){l.fixOrientation(t,i,a)}else{a.src=t}},false);var s=new XMLHttpRequest;s.open("GET",t,true);s.responseType="blob";s.onload=function(e){if(this.status==200||this.status===0){i.readAsArrayBuffer(this.response)}};s.send()}},false);f.style.display="none";a.appendChild(f);h.addEventListener("click",function(e){if(m.user_callback){l.snap(m.user_callback,m.user_canvas)}else{f.style.display="block";f.focus();f.click();f.style.display="none"}},false);a.appendChild(h);this.loaded=true;this.live=true}else if(this.params.enable_flash&&this.detectFlash()){e.Webcam=Webcam;var h=document.createElement("div");h.innerHTML=this.getSWFHTML();a.appendChild(h)}else{this.dispatch("error",new i(this.params.noInterfaceFoundText))}if(this.params.crop_width&&this.params.crop_height){var p=Math.floor(this.params.crop_width*r);var u=Math.floor(this.params.crop_height*o);a.style.width=""+p+"px";a.style.height=""+u+"px";a.style.overflow="hidden";a.scrollLeft=Math.floor(this.params.width/2-p/2);a.scrollTop=Math.floor(this.params.height/2-u/2)}else{a.style.width=""+this.params.width+"px";a.style.height=""+this.params.height+"px"}},reset:function(){if(this.preview_active)this.unfreeze();this.unflip();if(this.userMedia){if(this.stream){if(this.stream.getVideoTracks){var e=this.stream.getVideoTracks();if(e&&e[0]&&e[0].stop)e[0].stop()}else if(this.stream.stop){this.stream.stop()}}delete this.stream;delete this.video}if(this.userMedia!==true&&this.loaded&&!this.iOS){var t=this.getMovie();if(t&&t._releaseCamera)t._releaseCamera()}if(this.container){this.container.innerHTML="";delete this.container}this.loaded=false;this.live=false},set:function(){if(arguments.length==1){for(var e in arguments[0]){this.params[e]=arguments[0][e]}}else{this.params[arguments[0]]=arguments[1]}},on:function(e,t){e=e.replace(/^on/i,"").toLowerCase();if(!this.hooks[e])this.hooks[e]=[];this.hooks[e].push(t)},off:function(e,t){e=e.replace(/^on/i,"").toLowerCase();if(this.hooks[e]){if(t){var a=this.hooks[e].indexOf(t);if(a>-1)this.hooks[e].splice(a,1)}else{this.hooks[e]=[]}}},dispatch:function(){var t=arguments[0].replace(/^on/i,"").toLowerCase();var s=Array.prototype.slice.call(arguments,1);if(this.hooks[t]&&this.hooks[t].length){for(var r=0,o=this.hooks[t].length;r<o;r++){var n=this.hooks[t][r];if(typeof n=="function"){n.apply(this,s)}else if(typeof n=="object"&&n.length==2){n[0][n[1]].apply(n[0],s)}else if(e[n]){e[n].apply(e,s)}}return true}else if(t=="error"){var l;if(s[0]instanceof a||s[0]instanceof i){l=s[0].message}else{l="Could not access webcam: "+s[0].name+": "+s[0].message+" "+s[0].toString()}alert("Webcam.js Error: "+l)}return false},setSWFLocation:function(e){this.set("swfURL",e)},detectFlash:function(){var t="Shockwave Flash",a="ShockwaveFlash.ShockwaveFlash",i="application/x-shockwave-flash",s=e,r=navigator,o=false;if(typeof r.plugins!=="undefined"&&typeof r.plugins[t]==="object"){var n=r.plugins[t].description;if(n&&(typeof r.mimeTypes!=="undefined"&&r.mimeTypes[i]&&r.mimeTypes[i].enabledPlugin)){o=true}}else if(typeof s.ActiveXObject!=="undefined"){try{var l=new ActiveXObject(a);if(l){var h=l.GetVariable("$version");if(h)o=true}}catch(e){}}return o},getSWFHTML:function(){var t="",i=this.params.swfURL;if(location.protocol.match(/file/)){this.dispatch("error",new a("Flash does not work from local disk.  Please run from a web server."));return'<h3 style="color:red">ERROR: the Webcam.js Flash fallback does not work from local disk.  Please run it from a web server.</h3>'}if(!this.detectFlash()){this.dispatch("error",new a("Adobe Flash Player not found.  Please install from get.adobe.com/flashplayer and try again."));return'<h3 style="color:red">'+this.params.flashNotDetectedText+"</h3>"}if(!i){var s="";var r=document.getElementsByTagName("script");for(var o=0,n=r.length;o<n;o++){var l=r[o].getAttribute("src");if(l&&l.match(/\/webcam(\.min)?\.js/)){s=l.replace(/\/webcam(\.min)?\.js.*$/,"");o=n}}if(s)i=s+"/webcam.swf";else i="webcam.swf"}if(e.localStorage&&!localStorage.getItem("visited")){this.params.new_user=1;localStorage.setItem("visited",1)}var h="";for(var c in this.params){if(h)h+="&";h+=c+"="+escape(this.params[c])}t+='<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" type="application/x-shockwave-flash" codebase="'+this.protocol+'://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0" width="'+this.params.width+'" height="'+this.params.height+'" id="webcam_movie_obj" align="middle"><param name="wmode" value="opaque" /><param name="allowScriptAccess" value="always" /><param name="allowFullScreen" value="false" /><param name="movie" value="'+i+'" /><param name="loop" value="false" /><param name="menu" value="false" /><param name="quality" value="best" /><param name="bgcolor" value="#ffffff" /><param name="flashvars" value="'+h+'"/><embed id="webcam_movie_embed" src="'+i+'" wmode="opaque" loop="false" menu="false" quality="best" bgcolor="#ffffff" width="'+this.params.width+'" height="'+this.params.height+'" name="webcam_movie_embed" align="middle" allowScriptAccess="always" allowFullScreen="false" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" flashvars="'+h+'"></embed></object>';return t},getMovie:function(){if(!this.loaded)return this.dispatch("error",new a("Flash Movie is not loaded yet"));var e=document.getElementById("webcam_movie_obj");if(!e||!e._snap)e=document.getElementById("webcam_movie_embed");if(!e)this.dispatch("error",new a("Cannot locate Flash movie in DOM"));return e},freeze:function(){var e=this;var t=this.params;if(this.preview_active)this.unfreeze();var a=this.params.width/this.params.dest_width;var i=this.params.height/this.params.dest_height;this.unflip();var s=t.crop_width||t.dest_width;var r=t.crop_height||t.dest_height;var o=document.createElement("canvas");o.width=s;o.height=r;var n=o.getContext("2d");this.preview_canvas=o;this.preview_context=n;if(a!=1||i!=1){o.style.webkitTransformOrigin="0px 0px";o.style.mozTransformOrigin="0px 0px";o.style.msTransformOrigin="0px 0px";o.style.oTransformOrigin="0px 0px";o.style.transformOrigin="0px 0px";o.style.webkitTransform="scaleX("+a+") scaleY("+i+")";o.style.mozTransform="scaleX("+a+") scaleY("+i+")";o.style.msTransform="scaleX("+a+") scaleY("+i+")";o.style.oTransform="scaleX("+a+") scaleY("+i+")";o.style.transform="scaleX("+a+") scaleY("+i+")"}this.snap(function(){o.style.position="relative";o.style.left=""+e.container.scrollLeft+"px";o.style.top=""+e.container.scrollTop+"px";e.container.insertBefore(o,e.peg);e.container.style.overflow="hidden";e.preview_active=true},o)},unfreeze:function(){if(this.preview_active){this.container.removeChild(this.preview_canvas);delete this.preview_context;delete this.preview_canvas;this.preview_active=false;this.flip()}},flip:function(){if(this.params.flip_horiz){var e=this.container.style;e.webkitTransform="scaleX(-1)";e.mozTransform="scaleX(-1)";e.msTransform="scaleX(-1)";e.oTransform="scaleX(-1)";e.transform="scaleX(-1)";e.filter="FlipH";e.msFilter="FlipH"}},unflip:function(){if(this.params.flip_horiz){var e=this.container.style;e.webkitTransform="scaleX(1)";e.mozTransform="scaleX(1)";e.msTransform="scaleX(1)";e.oTransform="scaleX(1)";e.transform="scaleX(1)";e.filter="";e.msFilter=""}},savePreview:function(e,t){var a=this.params;var i=this.preview_canvas;var s=this.preview_context;if(t){var r=t.getContext("2d");r.drawImage(i,0,0)}e(t?null:i.toDataURL("image/"+a.image_format,a.jpeg_quality/100),i,s);if(this.params.unfreeze_snap)this.unfreeze()},snap:function(e,t){if(!e)e=this.params.user_callback;if(!t)t=this.params.user_canvas;var a=this;var s=this.params;if(!this.loaded)return this.dispatch("error",new i("Webcam is not loaded yet"));if(!e)return this.dispatch("error",new i("Please provide a callback function or canvas to snap()"));if(this.preview_active){this.savePreview(e,t);return null}var r=document.createElement("canvas");r.width=this.params.dest_width;r.height=this.params.dest_height;var o=r.getContext("2d");if(this.params.flip_horiz){o.translate(s.dest_width,0);o.scale(-1,1)}var n=function(){if(this.src&&this.width&&this.height){o.drawImage(this,0,0,s.dest_width,s.dest_height)}if(s.crop_width&&s.crop_height){var a=document.createElement("canvas");a.width=s.crop_width;a.height=s.crop_height;var i=a.getContext("2d");i.drawImage(r,Math.floor(s.dest_width/2-s.crop_width/2),Math.floor(s.dest_height/2-s.crop_height/2),s.crop_width,s.crop_height,0,0,s.crop_width,s.crop_height);o=i;r=a}if(t){var n=t.getContext("2d");n.drawImage(r,0,0)}e(t?null:r.toDataURL("image/"+s.image_format,s.jpeg_quality/100),r,o)};if(this.userMedia){o.drawImage(this.video,0,0,this.params.dest_width,this.params.dest_height);n()}else if(this.iOS){var l=document.getElementById(this.container.id+"-ios_div");var h=document.getElementById(this.container.id+"-ios_img");var c=document.getElementById(this.container.id+"-ios_input");iFunc=function(e){n.call(h);h.removeEventListener("load",iFunc);l.style.backgroundImage="none";h.removeAttribute("src");c.value=null};if(!c.value){h.addEventListener("load",iFunc);c.style.display="block";c.focus();c.click();c.style.display="none"}else{iFunc(null)}}else{var d=this.getMovie()._snap();var h=new Image;h.onload=n;h.src="data:image/"+this.params.image_format+";base64,"+d}return null},configure:function(e){if(!e)e="camera";this.getMovie()._configure(e)},flashNotify:function(e,t){switch(e){case"flashLoadComplete":this.loaded=true;this.dispatch("load");break;case"cameraLive":this.live=true;this.dispatch("live");break;case"error":this.dispatch("error",new a(t));break;default:break}},b64ToUint6:function(e){return e>64&&e<91?e-65:e>96&&e<123?e-71:e>47&&e<58?e+4:e===43?62:e===47?63:0},base64DecToArr:function(e,t){var a=e.replace(/[^A-Za-z0-9\+\/]/g,""),i=a.length,s=t?Math.ceil((i*3+1>>2)/t)*t:i*3+1>>2,r=new Uint8Array(s);for(var o,n,l=0,h=0,c=0;c<i;c++){n=c&3;l|=this.b64ToUint6(a.charCodeAt(c))<<18-6*n;if(n===3||i-c===1){for(o=0;o<3&&h<s;o++,h++){r[h]=l>>>(16>>>o&24)&255}l=0}}return r},upload:function(e,t,a){var i=this.params.upload_name||"webcam";var s="";if(e.match(/^data\:image\/(\w+)/))s=RegExp.$1;else throw"Cannot locate image format in Data URI";var r=e.replace(/^data\:image\/\w+\;base64\,/,"");var o=new XMLHttpRequest;o.open("POST",t,true);if(o.upload&&o.upload.addEventListener){o.upload.addEventListener("progress",function(e){if(e.lengthComputable){var t=e.loaded/e.total;Webcam.dispatch("uploadProgress",t,e)}},false)}var n=this;o.onload=function(){if(a)a.apply(n,[o.status,o.responseText,o.statusText]);Webcam.dispatch("uploadComplete",o.status,o.responseText,o.statusText)};var l=new Blob([this.base64DecToArr(r)],{type:"image/"+s});var h=new FormData;h.append(i,l,i+"."+s.replace(/e/,""));o.send(h)}};Webcam.init();if(typeof define==="function"&&define.amd){define(function(){return Webcam})}else if(typeof module==="object"&&module.exports){module.exports=Webcam}else{e.Webcam=Webcam}})(window);
		</script>
		
		Configure a few settings and attach camera
		<script language="JavaScript">
			Webcam.set({
				// live preview size
				width: 320,
				height: 240,
				
				// device capture size
				dest_width: 640,
				dest_height: 480,
				
				// final cropped size
				crop_width: 480,
				crop_height: 480,
				
				// format and quality
				image_format: 'jpeg',
				jpeg_quality: 90,
				
				// flip horizontal (mirror mode)
				flip_horiz: true
			});
			Webcam.attach( '#my_camera' );
		</script>
		
		A button for taking snaps
		<form>
			<div id="pre_take_buttons">
				This button is shown before the user takes a snapshot
				<input type=button value="Take Snapshot" onClick="preview_snapshot()">
			</div>
			<div id="post_take_buttons" style="display:none">
				These buttons are shown after a snapshot is taken
				<input type=button value="&lt; Take Another" onClick="cancel_preview()">
				<input type=button value="Save Photo &gt;" onClick="save_photo()" style="font-weight:bold;">
			</div>
		</form>
	</div>
	
	<div id="results" style="display:none" hidden="hidden">
		Your captured image will appear here...
	</div> 
	
	Code to handle taking the snapshot and displaying it locally
	<script language="JavaScript">
		// preload shutter audio clip
		var shutter = new Audio();
		shutter.autoplay = false;
		shutter.src = navigator.userAgent.match(/Firefox/) ? 'shutter.ogg' : 'shutter.mp3';
		
		function preview_snapshot() {
			// play sound effect
			try { shutter.currentTime = 0; } catch(e) {;} // fails in IE
			//shutter.play();
			
			// freeze camera so user can preview current frame
			Webcam.freeze();
			
			// swap button sets
			document.getElementById('pre_take_buttons').style.display = 'none';
			document.getElementById('post_take_buttons').style.display = '';
		}
		
		function cancel_preview() {
			// cancel preview freeze and return to live camera view
			Webcam.unfreeze();
			
			// swap buttons back to first set
			document.getElementById('pre_take_buttons').style.display = '';
			document.getElementById('post_take_buttons').style.display = 'none';
		}
		
		function save_photo() {
			// actually snap photo (from preview freeze) and display it
			Webcam.snap( function(data_uri) {
				// display results in page
				document.getElementById('results').innerHTML = '<img src="'+data_uri+'"/><br/></br>' ;
				// shut down camera, stop capturing
				Webcam.reset();
				// show results, hide photo booth
				document.getElementById('results').style.display = '';
				document.getElementById('my_photo_booth').style.display = 'none';
			} );
		}
	</script>
	
</body>
</html>
   -->

<%@ include file="footer.jsp" %>