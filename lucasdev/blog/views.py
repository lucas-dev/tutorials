from django.shortcuts import render_to_response,get_object_or_404
from django.core.paginator import Paginator, EmptyPage, PageNotAnInteger
from blog.models import Entry,Tag
def index(request):
	return render_to_response('index.html')

def entries(request):
	entries = Entry.objects.all()
	paginator = Paginator(entries,2)
	page = request.GET.get('page')
	try:
		entries = paginator.page(page)
	except PageNotAnInteger:
		# If page is not an integer, deliver first page.
		entries = paginator.page(1)
	except EmptyPage:
		# If page is out of range (e.g. 9999), deliver last page of results.
		contacts = paginator.page(paginator.num_pages)
	return render_to_response('blog/entries.html',
		{
			'tags':Tag.objects.all(),
			'entries':entries
		})

def entry(request,slug):
	return render_to_response('blog/entry.html',{'entry':get_object_or_404(Entry, slug=slug)})

def tags(request,slug):
	tags = Tag.objects.filter(slug=slug)
	entries = Entry.objects.filter(tag__in=tags)
	paginator = Paginator(entries,2)
	page = request.GET.get('page')
	try:
		entries = paginator.page(page)
	except PageNotAnInteger:
		# If page is not an integer, deliver first page.
		entries = paginator.page(1)
	except EmptyPage:
		# If page is out of range (e.g. 9999), deliver last page of results.
		contacts = paginator.page(paginator.num_pages)
	tags_all = Tag.objects.all()
	return render_to_response('blog/tags.html',
		{
			'entries':entries,
			'tags':tags_all
		})
	