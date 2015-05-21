/*--------------------------------Exercicios JQuery--------------------------------------*/

/*-1-*/
//a
$('.module')
//b
$('li')[11]
//c
$('label[for="q"]')
//d
$('*[alt]').length
//e
$('#fruits tbody tr:odd')
//f
$("h2:contains('B'):contains('e')").length
//g
$('#myList li')[4]
//h
$('#myList li:not(.current)')
//i
$('#myList .current').nextAll().text().length;

/*-2-*/
//a
console.log($('img'))
//b
$('input[type=text]').addClass('template')
//c
$('#myList li[class="current bar"]').removeClass("current bar").next().addClass("current bar")
//d
$('#specials h2').text("Promoções").next().next().contents().find('option[value="friday"]').text("Dimitri")
//e
$('#slideshow li').first().addClass("current").siblings().addClass("disabled")

/*-3-*/
//a
for(var i = 8 ; i<13;i++)
	$('#myList').append('<li>List item ' + i + '</li>')
//b
$('#myList li:odd').remove()
//c
$('div.module:last')
			.after(
			 	$ ('<div/>').addClass('module')
			 		.append( 
			 			$('img:eq(0)').clone() 
			 		) 
 );