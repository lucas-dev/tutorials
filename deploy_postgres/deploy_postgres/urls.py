from django.conf.urls import patterns, include, url

from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'deploy_postgres.views.home', name='home'),
    url(r'^$','deploy_postgres_app.views.home'),    
    url(r'^admin/', include(admin.site.urls)),
)
