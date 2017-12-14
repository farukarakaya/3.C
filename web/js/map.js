/**
 * Created by ofk on 10/10/17.
 */
var locations;
var clickedAnnouncementID;
var title ;
var city ;
var district;
var infowindow = null; //Info Pop-up
var geocity,geodistrict,geoaddress;
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
     //console.log(locations); // id
     clickedAnnouncementID = marker.id;
     setWindowData(marker.id);
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
function setWindowData(id) {
    console.log(id);
    console.log(locations)
    console.log(locations[id]);
    title = locations[id].title;
    city = locations[id].city;
    district = locations[id].district;
}
function clickAnnouncement(id) {
    sendID([{name:'ID', value:id}]);
}
function sendSelectedCity(scity) {
    //console.log(scity);
    sendCity([{name:'SelectedCity', value:scity}]);
    geocity = scity;
}
function sendSelectedDistrict(sdistrict) {
    //console.log(sdistrict);
    sendDistrict([{name:'SelectedDistrict', value:sdistrict}]);
    geodistrict = sdistrict;
}
function sendSelectedType(stype) {
    sendType([{name:'SelectedType', value:stype}]);
}
function sendND(needDonation) {
    sendNeedDonation([{name:'NeedDonation', value:needDonation}]);
}
function sendAdress(address) {
    console.log(address);
    geoaddress = address;
    SendAddress([{name:'Address', value:address}]);
}
function sendtitle(title) {
    console.log(title);
    SendTitle([{name:'Title', value:title}]);
}
function tab() {
    PF('sumbitNewAcordion').select(2);
}
function geocode() {
    console.log(geoaddress);
    var wholeAdress = "Türkiye " +geodistrict + " " + geocity + " " + geoaddress;
    console.log(wholeAdress);
    PF('geoMap').geocode(wholeAdress);
}

/*PF('sumbitNewAcordion').select(1);
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