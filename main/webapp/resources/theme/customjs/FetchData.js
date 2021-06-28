function GetXmlHttpObject()
{
    var xmlHttp = null;
    if (window.XMLHttpRequest) {
        xmlHttp = new window.XMLHttpRequest;
    } else {
        try {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (ex) {
            return null;
        }
    }
    return xmlHttp;
}//GetXmlHttpObject


function otentry(){
	 xmlHttp = GetXmlHttpObject();
	    var url = "employeeotentry";
	    xmlHttp.onreadystatechange = showmenudata1;
	    xmlHttp.open("GET", url, true);
	    xmlHttp.send(null);
}

function appsettings(){
	 xmlHttp = GetXmlHttpObject();
	    var url = "setting";
	    xmlHttp.onreadystatechange = showmenudata1;
	    xmlHttp.open("GET", url, true);
	    xmlHttp.send(null);
}



function salaryDeductions(){
	 xmlHttp = GetXmlHttpObject();
	    var url = "salaryDeductions";
	    xmlHttp.onreadystatechange = showmenudata1;
	    xmlHttp.open("GET", url, true);
	    xmlHttp.send(null);
}


function report(){
	xmlHttp = GetXmlHttpObject();
	    var url = "hrrepoter";
	    xmlHttp.onreadystatechange = showmenudata1;
	    xmlHttp.open("GET", url, true);
	    xmlHttp.send(null);
}
function salaryDeductions(){
	 xmlHttp = GetXmlHttpObject();
	    var url = "salaryDeductions";
	    xmlHttp.onreadystatechange = showmenudata1;
	    xmlHttp.open("GET", url, true);
	    xmlHttp.send(null);
}

function empinfo(){
	alert();
	 xmlHttp = GetXmlHttpObject();
	    var url = "employeeInformation";
	    xmlHttp.onreadystatechange = showmenudata1;
	    xmlHttp.open("GET", url, true);
	    xmlHttp.send(null);
}
function attsummary(){
	 xmlHttp = GetXmlHttpObject();
	    var url = "listAttendence";
	    xmlHttp.onreadystatechange = showmenudata1;
	    xmlHttp.open("GET", url, true);
	    xmlHttp.send(null);
}
function validateAtt(date){
  	 xmlHttp = GetXmlHttpObject();
  	    var url = "validateAttendence.jsp?date="+date;
  	    xmlHttp.onreadystatechange = showmenudata1;
  	    xmlHttp.open("GET", url, true);
  	    xmlHttp.send(null);
  }


function displayHrpunches(date,idno,shiftname,empname,designation,depname,attendid){
  	 xmlHttp = GetXmlHttpObject();
  	    var url = "displayhrpunches.jsp?date="+date+"&idno="+idno+"&shiftname="+shiftname+"&empname="+empname+"&designation="+designation+"&depname="+depname+"&attendid="+attendid;
  	    xmlHttp.onreadystatechange = showmenudata1;
  	    xmlHttp.open("GET", url, true);
  	    xmlHttp.send(null);
	
}

function updateHrPunchCodes(tranid,modifyType,attdate){
 	 xmlHttp = GetXmlHttpObject();
 	    var url = "updateHrPunchCodes.jsp?tranid="+tranid+"&modifyType="+modifyType+"&attdate="+attdate;
 	    xmlHttp.onreadystatechange = showmenudata1;
 	    xmlHttp.open("GET", url, true);
 	    xmlHttp.send(null);
}
function openEditPage(tranid)
{
	xmlHttp = GetXmlHttpObject();
	   	var url = "EditEmployees.jsp?tranid="+tranid;
	    xmlHttp.onreadystatechange = showmenudata1;
	    xmlHttp.open("GET", url, true);
	    xmlHttp.send(null);
}

function  openfamilyEditPage(tranid,parenttranid)
{  
	xmlHttp = GetXmlHttpObject();
    var url = "EditFamily.jsp?tranid="+tranid+"&parenttranid="+parenttranid;
    xmlHttp.onreadystatechange = showmenudata1;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);

}
function openExperienceEditPage(tranid,parenttranid)
{ 
	xmlHttp = GetXmlHttpObject();
	var url = "EditExperience.jsp?tranid="+tranid+"&parenttranid="+parenttranid;
    xmlHttp.onreadystatechange = showmenudata1;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
}
function openEducationEditPage( tranid ,parenttranid)
{
    xmlHttp = GetXmlHttpObject();
    var url = "EditEducation.jsp?tranid="+tranid+"&parenttranid="+parenttranid;
    xmlHttp.onreadystatechange = showmenudata1;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);

}
function openSalaryDeductionEditPage(idno)
{
	 xmlHttp = GetXmlHttpObject();
	    var url = "getSalaryDeductionInformationByIdno?idno="+idno;
	    xmlHttp.onreadystatechange = showmenudata1;
	    xmlHttp.open("GET", url, true);
	    xmlHttp.send(null);

}
function logout(){
	xmlHttp = GetXmlHttpObject();
    var url = "logout";
    xmlHttp.onreadystatechange = showmenudata6;
    xmlHttp.open("POST", url, true);
    xmlHttp.send(null);
}

function showmenudata1()
{
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete")
    {
    	$("#data").html(xmlHttp.responseText);
       // var values=xmlHttp.responseText;  
        //document.getElementById('data').innerHTML=values; 
    }
}
function showmenudata6()
{
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete")
    {
       window.location.reload();
       // var val=xmlHttp.responseText;  
       // document.getElementById('data').innerHTML=val; 
    }
}
