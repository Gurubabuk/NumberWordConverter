<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("button").click(function(){
	  var inp=$("#num").val();
	 	$.ajax({
		  
		    url: 'number',
		    data: 'number='+ inp,
		    datatype:'text',
		    success: function(msg){
		       $("#result").html(msg);
		    }
		});
  });
});
</script>
<style>
.bg{background-color: #9e9e9e4a}
.fld{
    margin: 17% 31% 1% 32%;
}
.rslt{margin-left:32%;color:#da0c0c}
button{    background: #e20808;
    color: #fff;}
</style>

</head>
<body class="bg">
<div class="content">
<div class="fld"> <div>Enter Number</div> <input type="text" id="num" />
<button>Convert</button>
</div>
<div id="result" class=rslt></div>  
</div>
</body>
</html>

