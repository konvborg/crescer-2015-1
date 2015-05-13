////////////////////////////////1
//a
$('.module')
//b
$('#myList :eq(2)')
//c
$('#search label[for=q]')
//d
$('[alt]').length
//e
$('#fruits tbody tr :odd')
$('#fruits tr:even:not(:first-child)')
//f
$('h2:contains("B"):contains("e")').length
//g
$('#myList li not:(.current)')
//h
$('li:last-of-type img, li:last-of-type h3')
$('img:last, h3:last')
//i
$('#myList .current ~ li').text().length;
$('#myList .current').nextAll().text().length;
//////////////////////////////3
//c
$('div.module:last')
			.after(
			 	$ ('<div/>').addClass('module')
			 		.append( 
			 			$('img:eq(0)').clone() 
			 		) 
            );