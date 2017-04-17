<html>
<body>

<form>
NAME: <input type="text" name="name" id="name"/> <br/>
AGE: <input type="text" name="age" id="age"/> <br/>
REMARK: <input type="text" name="remark" id="remark"/> <br/>
<input type="button" value="提交" onclick="getPrimaryKey()"/>
</form>

<div id="box"></div>

<script type="text/javascript">
	
	function getPrimaryKey(){
		var xmlHttp = "";
		
		if(window.XMLHttpRequest){
			xmlHttp = new XMLHttpRequest();
		}else{
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlHttp.onreadystatechange = function(){
			
			if(xmlHttp.status == 200 && xmlHttp.readyState==4){
			
				var txt = xmlHttp.responseText;
				var box = document.getElementById("box");
				box.innerHTML = txt;
			
			}
			
		}
		var name = document.getElementById("name");
		var age = document.getElementById("age");
		var remark = document.getElementById("remark");
		xmlHttp.open("GET", "getPK?name="+name.value+"&age="+age.value+"&remark="+remark.value, true);	
		xmlHttp.send();
	}


</script>

</body>
</html>
