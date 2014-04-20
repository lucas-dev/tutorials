from django.shortcuts import render_to_response
from deploy_postgres_app.models import Entry
def home(request):
	return render_to_response("index.html",
		{
			"entries":Entry.objects.all()
		});
