$(document).ready(function(){
	setDisplay();
});

$(window).resize(function(){     
	setDisplay();
});

function setDisplay(){
	var viewportWidth = $(window).width();
   if(viewportWidth>0 && viewportWidth < 1200){
   		$("#div-right").insertBefore("#div-left");
   		$("br").css("display","none");
   		$("#p-share").css("display","none");
   		$("#tags").css("margin-top","10px");
   		$("#tags").css("margin-bottom","10px");
   }else{
   		$("#div-left").insertBefore("#div-right");
   		$("br").css("display","");
   		$("#p-share").css("display","");
   		$("#tags").css("margin-top","");
   		$("#tags").css("margin-bottom","");
   }
}