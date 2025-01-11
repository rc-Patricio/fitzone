<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css"
integrity="sha256-p4NxAoJBhIIN+hmNHrzRCf9tD/miZyoHS5obTRR9BMY="
crossorigin=""/>
<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"
integrity="sha256-20nQCchB9co0qIjJZRGuk2/Z9VM+kNiyxNV1lvTlZBo="
crossorigin=""></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/styles.css"/>
<title>${localizacion.nombre}</title>
</head>
<body>
	<h2>${localizacion.nombre}</h2>
	
    <h3>${localizacion.direccion}</h3>

    <div id="map" style="width: 600px; height: 400px;"></div>

	<script>

        var coordX = parseFloat('${localizacion.cordX}');
        var coordY = parseFloat("${localizacion.cordY}");

		var map = L.map('map').setView([coordX, coordY], 13);
		L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
		maxZoom: 19,
		attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
		}).addTo(map);

		/*function onMapClick(e) {
			var marker = L.marker(mouseEventToLatLng(e).addTo(map));
		}

		map.on('click', function(ev) {
			var marker = L.marker(ev.latlng).addTo(map);
		});*/
		
        var marker = L.marker([coordX, coordY]).addTo(map);
		
	</script>

</body>
</html>