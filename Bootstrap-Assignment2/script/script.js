$('.collapse').on('shown.bs.collapse', function(){
	    		$(this).parent().find(".glyphicon-plus").removeClass("glyphicon-plus").addClass("glyphicon-minus");
	    		$(this).parent().find(".third-panel").removeClass("third-panel").addClass("bottom-radius-zero");
	    	}).on('hidden.bs.collapse', function(){
	    		$(this).parent().find(".glyphicon-minus").removeClass("glyphicon-minus").addClass("glyphicon-plus");
	    		$(this).parent().find(".bottom-radius-zero").removeClass("bottom-radius-zero").addClass("third-panel");
	    	});
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();  
    $('.active-menu').css('background-color','#c36464').siblings().css('background-color', '#222');
    
    $("#menu li").click(function() {
    	$(this).css('background-color','#c36464').siblings().css('background-color', '#222');
    });
});