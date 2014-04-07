from django.db import models
from django.db.models import permalink

class Tag(models.Model):
	name = models.CharField(max_length=100,db_index=True)
	slug = models.SlugField(max_length=100,db_index=True)

	class Meta:
		verbose_name_plural = 'Tags'
	def __unicode__(self):
		return '%s'%self.name

	@permalink
	def get_absolute_url(self):
		return ('blog_tags', None, {'slug': self.slug})


class Entry(models.Model):
	title = models.CharField(max_length=100,unique=True)
	slug = models.SlugField(max_length=100,unique=True)
	content = models.TextField()
	date = models.DateTimeField(db_index=True,auto_now_add=True)
	tag = models.ManyToManyField(Tag)
	preview = models.TextField()

	class Meta:
		ordering = ['-date']
		verbose_name_plural = 'Entries'
	def __unicode__(self):
		return '%s'%self.title

	@permalink
	def get_absolute_url(self):
		return ('blog_entries', None, {'slug': self.slug})

#nota: permalink comunica con urls, y busca en cada entrada de urls el name que coincide con el
#primer parametro de get_absolute_url