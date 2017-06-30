$.ajaxSetup({
    statusCode: {
        401: function() {
            console.error('401 - Unauthorized');
        },
        403: function() {
        	console.error('403 - Forbidden');
        }
    }
});