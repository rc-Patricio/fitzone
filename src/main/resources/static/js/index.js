var map = L.map('map').setView([-36.82, -73.03], 13);

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
maxZoom: 19,
attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);

let marcador = null;

function onMapClick(e) {
    if(!marcador){
        var marker = L.marker(mouseEventToLatLng(e).addTo(map));
    }
    
}

map.on('click', async function(ev) {
    const { lat, lng } = ev.latlng;
    if(!marcador){
        marcador = L.marker(ev.latlng).addTo(map);
    }
    else{
        marcador.setLatLng([lat, lng]);
        
    }
    var urlApi="https://nominatim.openstreetmap.org/reverse?format=json&lat=" + lat + "&lon=" + lng + "&zoom=14&addressdetails=1";

    try {
        const direccion = await getGoogleAddress(lat, lng);
        document.getElementById("direccion").value = direccion;
        document.getElementById("cordX").value = lat;
        document.getElementById("cordY").value = lng;
        console.log("Ciudad encontrada:", direccion);
        console.log(direccion);

    } catch (error) {
        console.error("Error al obtener los datos de la API:", error);
        document.getElementById("direccion").value = "Error al obtener la ciudad";
    }
});


async function getGoogleAddress(lat, lng) {
    const apiKey = 'AIzaSyDtbYmlsIcrsZT_ztF7UXpO58q98_fxJaI'; // Reemplaza con tu API Key de Google
    const url = `https://maps.googleapis.com/maps/api/geocode/json?latlng=${lat},${lng}&key=${apiKey}`;
    
    try {
        const response = await fetch(url);
        const data = await response.json();
        
        if (data.status === "OK") {
            const address = data.results[0].formatted_address;
            console.log("Dirección:", address);
            return address;
        } else {
            console.error("Error en la respuesta de la API de Google Maps:", data.status);
        }
    } catch (error) {
        console.error("Error al llamar a la API de Google Maps:", error);
    }
}

