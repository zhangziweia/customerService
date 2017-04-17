<html>
<head>
	<meta charset="utf-8"/> 
	<title>MAVEN-SSM</title>
</head>
<body>
<button id="btn" onclick="findByNameUser()">press</button>
<div id="box"></div>
<script type="text/javascript">
	var un = document.getElementById("btn");
	
	
	function findByNameUser(){
	var xmlHttp = null;
	
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.status == 200 && xmlHttp.readyState == 4){
			var box = document.getElementById("box");
			var user = eval("("+xmlHttp.responseText +")");
			
			for(var i=0;i<user.length;i++)
			{
				box.innerHTML += "ID="+user[i]["id"] +",NAME="+user[i]["user_name"]+",AGE="+user[i]["age"]+",REMARK="+user[i]["remark"]+"<br/>";
			}
			
		}
	}

	xmlHttp.open("get", "findAll", true);
	xmlHttp.send();
}
	

</script>	

</body>
</html>
