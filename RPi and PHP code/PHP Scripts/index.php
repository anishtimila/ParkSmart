<?php
$con=mysqli_connect("localhost","root","password","test");
// Check connection
if (mysqli_connect_errno())
{
echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$result = mysqli_query($con,"SELECT rowNo, lotName, COUNT(*) AS FreeSpace FROM lot1 WHERE State=0 GROUP BY rowNo");
$json = array();
$info = array();

while($row = mysqli_fetch_array($result))
{
	$json["rowNo"] = $row["rowNo"];
	$json["lotName"] = $row["lotName"];
	$json["FreeSpace"] = $row["FreeSpace"];
	$info[] = $json;
}


echo json_encode($info);

mysqli_close($con);
?>
