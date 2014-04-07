from django.contrib.sitemaps import Sitemap
from blog.models import Entry

class BlogSitemap(Sitemap):
	changefreq = "never"
	priority = 0.5

	def items(self):
		return Entry.objects.all()

	def lastmod(self, obj):
		return obj.date

	#def location(self,obj):
	#	return '/'