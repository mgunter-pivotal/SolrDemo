curl http://kla.app.mgpcf.net/solr/collectionManaged/schema/fields -X POST -H 'Content-type:application/json' --data-binary '[ { "name":"doctype","type":"text_general","indexed":true,"stored":true}]'
