<?php
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// get all products from products table
$result = mysql_query("SELECT rowNo, lotName, COUNT(*) AS FreeSpace FROM lot1 WHWEW State=0 GROUP BY rowNo") or die(mysql_error());
 
// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // products node
    $response["lot1"] = array();
 
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $lot1 = array();
        $lot1["sensorID"] = $row["sensorID"];
        $lot1["lotName"] = $row["lotName"];
        $lot1["rowNo"] = $row["rowNo"];
	$lot1["parkingSpot"] = $row["parkingSpot"];
	$lot1["State"] = $row["State"];
 
        // push single product into final response array
        array_push($response["lot1"], $lot1);
    }
    // success
    $response["success"] = 1;
 
    // echoing JSON response
    echo json_encode($response);
} else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No parts inserted";
 
    // echo no users JSON
    echo json_encode($response);
}
?>