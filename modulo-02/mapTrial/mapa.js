function initMap(){ //inicializa o mapa
  var directionsService = new google.maps.DirectionsService();
  directionsDisplay = new google.maps.DirectionsRenderer();
    var map = new google.maps.Map(document.getElementById('map'), {
      center: {lat: -30.0277, lng:  -51.2287}, //onde o mapa é startado
      zoom: 6
    });
    directionsDisplay.setMap(map);
    var marker = new google.maps.Marker({ //adicionar marcador
        position: {lat: -30.0277, lng:  -51.2287}, //posicionar marcador
        map: map
    });
}  
    
   

