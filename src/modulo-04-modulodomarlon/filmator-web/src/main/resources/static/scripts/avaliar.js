$('.star').click(function(){
				$(this).prevAll().attr('src', '/img/estrelacheia.png');
				$(this).nextAll().attr('src', '/img/estrelavazia.png');
				$(this).attr('src', '/img/estrelacheia.png');
				
				var nota = $( this ).attr('value');
				var filme = $( this ).parent().attr('value');
				$.ajax({
					url: '/avaliar?nota=' + nota + '&idfilme=' + filme,
					type: 'POST'
				});
});
