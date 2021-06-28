

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

function newEmployee(){
	xmlHttp = GetXmlHttpObject();
	var url = "redirectNewEmployee";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}



function attsummary(){

	var date=new Date();
	var val=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate()-1);

	xmlHttp = GetXmlHttpObject();
	var url = "listAttendence";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function usercompmapping(){
	xmlHttp = GetXmlHttpObject();
	var url = "usercompmapping";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function jobstatus(){
	xmlHttp = GetXmlHttpObject();
	var url = "jobstatus";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
//for jobtype
function jobtype(){
	alert("hil");
	xmlHttp = GetXmlHttpObject();
	var url = "jobtype";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
//for cadre
function cadre(){
	xmlHttp = GetXmlHttpObject();
	var url = "cadre";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
//for department
function department(){
	xmlHttp = GetXmlHttpObject();
	var url = "department";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
//for section
function sections(){
	xmlHttp = GetXmlHttpObject();
	var url = "sections";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
//for projects
function projects(){
	xmlHttp = GetXmlHttpObject();
	var url = "projects";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function gradesList(){
	xmlHttp = GetXmlHttpObject();
	var url = "gradesList";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function jobDetails(){
	xmlHttp = GetXmlHttpObject();
	var url = "jobDetails";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function familyDetails(){
	xmlHttp = GetXmlHttpObject();
	var url = "familyDetails";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function division(){
	xmlHttp = GetXmlHttpObject();
	var url = "division";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function goToLeaves(idNumber){
	alert("bfsj");
	xmlHttp = GetXmlHttpObject();
	var url = "leaves.jsp?idno="+idNumber;
	
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
	console.log(idNumber);
}
function save(){
	xmlHttp = GetXmlHttpObject();
	var url = "savejobstatus";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}

function addleave(){
	xmlHttp = GetXmlHttpObject();
	var url = "savejobstatus";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
//for division save controller object
function divisionsave(){
	xmlHttp = GetXmlHttpObject();
	var url = "savedivision";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}

/*function saveGrade(){
	xmlHttp = GetXmlHttpObject();
	var url = "savegrade";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}*/
function saveBlood(){
	xmlHttp = GetXmlHttpObject();
	var url = "savebgroup";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function saveEstatus(){
	xmlHttp = GetXmlHttpObject();
	var url = "saveEmpstatus";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}

function empstatus(){
	xmlHttp = GetXmlHttpObject();
	var url = "empstatus";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function bgroup(){
	xmlHttp = GetXmlHttpObject();
	var url = "bgroup";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function openEditPage(tranid,idno,name,dateofjoining,dateOfBirth,employeeStatus){
	xmlHttp = GetXmlHttpObject();
	var url = "EditEmployees.jsp?tranid="+tranid+"&idno="+idno+"&name="+name+"&dateofjoining="+dateofjoining+"&dateOfBirth="+dateOfBirth+"&employeeStatus="+employeeStatus;
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}

function openEditJob(jobstatusid,description,statusCodeForActive){
	xmlHttp = GetXmlHttpObject();
	var url = "editjobstatus.jsp?jobstatusid="+jobstatusid+"&description="+description+"&isactive="+statusCodeForActive;
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function openEditGrade(gradeno,code,description,cadrecode,statusCodeForActive){
	xmlHttp = GetXmlHttpObject();
	var url = "editGradeList.jsp?gradeno="+gradeno+"&code="+code+"&description="+description+"&cadrecode="+cadrecode+"&isactive="+statusCodeForActive;
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function openEditEmp(empstatusid,description,statusCodeForActive){
	xmlHttp = GetXmlHttpObject();
	var url = "editEmpStatus.jsp?empstatusid="+empstatusid+"&description="+description+"&isactive="+statusCodeForActive;
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function openEditBlood(tranid,bloodgroup){
	xmlHttp = GetXmlHttpObject();
	var url = "editBGroup.jsp?tranid="+tranid+"&bloodgroup="+bloodgroup;
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}



function openSavejob(jobstatusid,description){
	xmlHttp = GetXmlHttpObject();
	var url = "saveJobstatus.jsp?jobstatusid="+jobstatusid+"&description="+description;
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}


function  openAttendenceModify(idno,date){
	xmlHttp = GetXmlHttpObject();
	var url = "attendenceModify?idno="+idno+"&date="+date;
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function validateAtt(){
	var date =document.getElementById("appendedDate").value;
	xmlHttp = GetXmlHttpObject();
	var url = "validateAttendence.jsp?date="+date;
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
//function for open division editing page
function openEditdivision(divisionid){
	xmlhttp = GetXmlHttpObject();
	var url="editdivision.jsp?divisionid="+divisionid;
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}

function leaveposting(){
	xmlHttp = GetXmlHttpObject();
	var url = "leaveposting";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
//calling leaves.jsp page throw controller url
function leavedebit(){

	xmlHttp = GetXmlHttpObject();
	var url = "leavedebit";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
//calling leaves.jsp page throw controller url
function leave(){
	xmlHtp = GetXmlHttpObject();
	var url = "leave";
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
//function for open edit leave page
function openEditLeave(transid,idNumber){
	xmlHttp = GetXmlHttpObject();
	var url = "EditLeave.jsp?transid="+transid+"&idno="+idNumber;
	xmlHttp.onreadystatechange = showmenudata1;ss
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}

function openeditPage(idNumber){
	xmlHttp = GetXmlHttpObject();
	var url = "leaves.jsp?idno="+idNumber;
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
function showmenudata1()
{
	if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete")
	{
		$("#data").html(xmlHttp.responseText);
	}
}
function modaldata()
{
	if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete")
	{
		var values=xmlHttp.responseText;  
		document.getElementById('data').innerHTML=values; 
	}
}


