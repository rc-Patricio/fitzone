
var map = L.map('map').setView([-36.82, -73.03], 13);


L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);

document.querySelectorAll("[data-cordx][data-cordy]").forEach(element => {
    const cordx = parseFloat(element.getAttribute("data-cordx"));
    const cordy = parseFloat(element.getAttribute("data-cordy"));

    if (!isNaN(cordx) && !isNaN(cordy)) {
        L.marker([cordx, cordy]).addTo(map);
    } else {
        console.warn('Coordenadas no válidas:', cordx, cordy);
    }
});
