from django.conf.urls import patterns, include, url
from django.contrib.sitemaps.views import sitemap
from lucasdev.sitemap import BlogSitemap
from django.contrib import admin
admin.autodiscover()

sitemaps = {
	'blog':BlogSitemap
}

urlpatterns = patterns('',
    url(r'^blog/entry/(?P<slug>[^\.]+).html', 'blog.views.entry', name='blog_entries'),
    url(r'^blog/tags/(?P<slug>[^\.]+).html', 'blog.views.tags', name='blog_tags'),
    url(r'^blog','blog.views.entries'),
    #url(r'^tags','blog.views.tags'),
    url(r'^admin/', include(admin.site.urls)),
    url(r'^sitemap\.xml$', sitemap, {'sitemaps': sitemaps}),
    url(r'^','blog.views.index'),
)
