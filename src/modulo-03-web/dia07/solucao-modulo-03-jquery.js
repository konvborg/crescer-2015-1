// 1A
$('.module');

// 1B
$('#myList :eq(2)');

// 1C
$('#search label[for=q]');

// 1D
$('[alt]').size();

// 1E
$('#fruits tbody tr:even');
$('#fruits tr:even:not(:first-child)');

// 1F
$('h2:contains(B):contains(e)').size();

// 1G
$('#myList li').not('.current')
$('#myList li:not(.current)')

// 1H
$('img:last, h3:last');
$('li:last-of-type img, li:last-of-type h3')

// 1I
$('#myList .current ~ li').text().length;
$('#myList .current').nextAll().text().length;

// 2A


// 3C
$('div.module')
	.last()
	.after(
		$('<div/>').addClass('module')
			.append(
				$('img:eq(0)').clone()
			)
		);












