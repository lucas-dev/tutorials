from django.contrib import admin
from blog.models import Entry, Tag

class AdminEntry(admin.ModelAdmin):
	list_display = ('title','date','content','slug')
	list_filter = ('title','date')
	ordering = ('-date',)
	search_field = ('title',)

admin.site.register(Entry, AdminEntry)

class AdminTag(admin.ModelAdmin):
	list_display = ('name','slug')

admin.site.register(Tag, AdminTag)
