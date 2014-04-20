from django.contrib import admin
from deploy_postgres_app.models import Entry

class AdminEntry(admin.ModelAdmin):
	list_display = ('text',)

admin.site.register(Entry, AdminEntry)