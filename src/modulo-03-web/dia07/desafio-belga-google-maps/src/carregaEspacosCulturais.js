'use strict';

var options = {
	resource_id: '1ac41c33-fcd5-4b42-890f-a7bad6216663', // espaços culturais,
	data_poa_url: 'http://datapoa.com.br/api/action/datastore_search',
	poa_coords: { lat: -30.032778, long: -51.23 }
};

var espacosCulturais = [];

google.maps.event.addDomListener(window, 'load', initialize);

function initialize() {
	obtemDadosPorAjax();
}

function obtemDadosPorAjax() {

	var data = {
		resource_id: options.resource_id
	};

  $.ajax({
    url: options.data_poa_url,
    data: data,
    dataType: 'jsonp',
    success: function(data) {

    	// utilizando extend para copiar os objetos
      espacosCulturais = $.extend({}, data.result.records);
      renderizaMapa();

    }
  });

}

function renderizaMapa() {

	var mapOptions = {
  	zoom: 13,
  	center: new google.maps.LatLng(options.poa_coords.lat, options.poa_coords.long)
	};

 	var map = new google.maps.Map($("#mapContainer")[0], mapOptions);

 	$.each(espacosCulturais, function(i, elem) {
 		console.log(elem);

		var marker = new google.maps.Marker({
			position: new google.maps.LatLng(elem.Latitude, elem.Longitude),
		  map: map,
		  title: elem.Name
		});

		// criando objeto para exibir infos do marcador no mapa.
 		var info = new google.maps.InfoWindow({
 			content: criaHTMLdeInfoParaMarcador(elem)
 		});

		// registrando evento de clique em cima do marcador
		google.maps.event.addListener(marker, 'click', function() {
			info.open(map, marker);
		});

 	});

}

function criaHTMLdeInfoParaMarcador(espacoCultural) {
	return "<h2>" + espacoCultural.Name + "</h2>" +
		"<h4>" + espacoCultural.Tipo + "</h4>" +
		// acessando como hash pois o campo possui espaços
		"<address>" + espacoCultural['Endereço Formatado'] + "</address>" +
		"<address>" + espacoCultural.Bairro + "</address>" +
		"<address>" + espacoCultural['Região OP'] + "</address>" +
		"<hr>" +
		"<a href='" + espacoCultural.URL + "'>Site</a>";
}