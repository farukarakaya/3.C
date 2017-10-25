/**
 * Created by ofk on 10/10/17.
 */
var locations;
var clickedAnnouncementID;
var title = 'dfrefr';
var city = 'dfrfwrfw';
var district ='wefds';
var infowindow = null; //Info Pop-up
function getAnnouncements(locs) {
    locations = locs;
}
function initMap() {
    //console.log(locations);

    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 6,
        center: {lat:39.024, lng: 35.347}
    });

    // Create an array of alphabetical characters used to label the markers.

    // Add some markers to the map.
    // Note: The code uses the JavaScript Array.prototype.map() method to
    // create an array of markers based on a given "locations" array.
    // The map() method here has nothing to do with the Google Maps API.
    var markers = locations.map(function(location) {
        var marker=  new google.maps.Marker({
            position: location.pos,
            id: location.id
        });
        marker.addListener('click', function() {
            if(infowindow != null) infowindow.close();
            setWindowContext(map,marker)
        });
        return marker;
    });

    // Add a marker clusterer to manage the markers.
    var markerCluster = new MarkerClusterer(map, markers,
        {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
}

function setWindowContext(map,marker) {
     console.log(marker.id); // id
     clickedAnnouncementID = marker.id;
     var infoWindowContext = '<div id="content">'+
        '<div id="siteNotice">'+
        '</div>'+
        '<h1 id="firstHeading" class="firstHeading">'+title+'</h1>'+
        '<img id="myImg" src="images/embed2.jpg" width="120" height="100" style="float: left">'+
        '<div id="container" style="float: left">'+
        '<div id="CityLabel">City:'+city+'</div>'+
        '<div id="DistrictLabel">District:'+district+'</div>'+
        '<button type="button" id="myBtn"onclick="clickAnnouncement(clickedAnnouncementID)">Try it</button>'+
        '</div></div>';

    infowindow = new google.maps.InfoWindow({
        content: infoWindowContext
    });
    infowindow.open(map, marker);
}
function clickAnnouncement(id) {
    if(infowindow != null)infowindow.close();
    //PF('announcementPopup').close();
    //console.log(id);
    sendID([{name:'ID', value:id}]);
    PF('announcementPopup').show();

}

/*var locations = [
    {id: 0,pos:{lat: -31.563910, lng: 147.154312}},
    {id: 1,pos:{lat: -33.718234, lng: 150.363181}},
    {id: 2,pos:{lat: -33.727111, lng: 150.371124}},
    {id: 3,pos:{lat: -33.848588, lng: 151.209834}},
    {id: 4,pos:{lat: -33.851702, lng: 151.216968}},
    {id: 5,pos:{lat: -34.671264, lng: 150.863657}},
    {id: 6,pos:{lat: -35.304724, lng: 148.662905}},
    {id: 7,pos:{lat: -36.817685, lng: 175.699196}},
    {id: 8,pos:{lat: -36.828611, lng: 175.790222}},
    {id: 9,pos:{lat: -37.750000, lng: 145.116667}},
    {id: 10,pos:{lat: -37.759859, lng: 145.128708}},
    {id: 11,pos:{lat: -37.765015, lng: 145.133858}},
    {id: 12,pos:{lat: -37.770104, lng: 145.143299}},
    {id: 13,pos:{lat: -37.773700, lng: 145.145187}},
    {id: 14,pos:{lat: -37.774785, lng: 145.137978}},
    {id: 15,pos:{lat: -37.819616, lng: 144.968119}},
    {id: 16,pos:{lat: -38.330766, lng: 144.695692}},
    {id: 17,pos:{lat: -39.927193, lng: 175.053218}},
    {id: 18,pos:{lat: -41.330162, lng: 174.865694}},
    {id: 19,pos:{lat: -42.734358, lng: 147.439506}},
    {id: 20,pos:{lat: -42.734358, lng: 147.501315}},
    {id: 21,pos:{lat: -42.735258, lng: 147.438000}},
    {id: 22,pos:{lat: -43.999792, lng: 170.463352}}
    ]

 '+
 '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +
 'sandstone rock formation in the southern part of the '+
 'Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) '+
 'south west of the nearest large town, Alice Springs; 450&#160;km '+
 '(280&#160;mi) by road. Kata Tjuta and Uluru are the two major '+
 'features of the Uluru - Kata Tjuta National Park. Uluru is '+
 'sacred to the Pitjantjatjara and Yankunytjatjara, the '+
 'Aboriginal people of the area. It has many springs, waterholes, '+
 'rock caves and ancient paintings. Uluru is listed as a World '+
 'Heritage Site.</p>'+
 '<p>Attribution: Uluru, <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'+
 'https://en.wikipedia.org/w/index.php?title=Uluru</a> '+
 '(last visited June 22, 2009).</p>'+

 '<div id="bodyContent">'+detail+'</div>'+
 '<div id="bottom">'+ cdetail+'</div>+
 */