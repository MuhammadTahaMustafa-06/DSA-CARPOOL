function toggleMapAndSearch() {
    var updateForm = document.getElementById('updateForm');
    var mapContainer = document.getElementById('map').parentNode.parentNode; // Adjust as needed
    var searchMapContainer = document.querySelector('.search-map-container'); // Adjust as needed

    if (updateForm.classList.contains('hidden')) {
        // Show update form, hide map container and search bar
        updateForm.classList.remove('hidden');
        mapContainer.style.display = 'none';
        searchMapContainer.style.display = 'none';
    } else {
        // Show map container and search bar, hide update form
        updateForm.classList.add('hidden');
        mapContainer.style.display = 'block';
        searchMapContainer.style.display = 'block';
    }
}

// Attach click event to the "Update Details" link in the sidebar to trigger the toggle
document.getElementById('dashboardLink').addEventListener('click', function (event) {
    event.preventDefault(); // Prevent default link behavior

    // Call the toggle function
    toggleMapAndSearch();
});
var mymap = L.map('map').setView([24.8607, 67.0011], 12); // Centered on Karachi

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '© OpenStreetMap contributors'
}).addTo(mymap);

var locations; // Global variable to store CSV data

// Load and parse the CSV file
Papa.parse("resources\\karachi_areasfinal.csv", {
    header: true,
    dynamicTyping: true,
    complete: function(results) {
        locations = results.data;

        // Add markers for each location
        locations.forEach(function(location) {
            var marker = L.marker([location.latitude, location.longitude]).addTo(mymap);

            // Add a popup with coordinates
            marker.bindPopup(`Coordinates: ${location.latitude}, ${location.longitude}<br>${location.name}`);
        });
    }
});

function searchLocation() {
    var locationInput = document.getElementById('locationInput').value;
    // Use Nominatim API for geocoding
    fetch(`https://nominatim.openstreetmap.org/search?format=json&q=${locationInput}, Karachi`)
        .then(response => response.json())
        .then(data => {
            if (data.length > 0) {
                var latlng = [parseFloat(data[0].lat), parseFloat(data[0].lon)];

                // Update map view and add a marker with popup
                mymap.setView(latlng, 12);
                var marker = L.marker(latlng).addTo(mymap);
                marker.bindPopup(`Coordinates: ${latlng[0]}, ${latlng[1]}<br>${data[0].display_name}`).openPopup();

                // Print coordinates
                console.log('Latitude: ' + latlng[0]);
                console.log('Longitude: ' + latlng[1]);
            } else {
                alert('Location not found');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
function getCurrentLocationAndSearch() {
    if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition(
            function (position) {
                var latitude = position.coords.latitude;
                var longitude = position.coords.longitude;

                // Call the searchLocation function with the obtained coordinates
                searchLocation(latitude, longitude);
            },
            function (error) {
                console.error("Error getting geolocation:", error.message);
                alert("Error getting geolocation. Please try again.");
            }
        );
    } else {
        alert("Geolocation is not supported by your browser.");
    }
}
