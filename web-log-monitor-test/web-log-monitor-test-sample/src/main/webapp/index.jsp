<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h2>logging ..... </h2>
</body>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(function() {
		testlog();
	})
	window.setInterval(testlog, 5000);
	function testlog() {
		$.ajax({
			url : "log/test",
			async : false
		});
	}
</script>
</html>
