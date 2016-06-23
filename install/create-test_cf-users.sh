#/bin/sh

cf create-user user1 user1user1
cf create-org user1-org
cf set-org-role user1 user1-org OrgManager
cf create-space Development -o user1-org
cf set-space-role user1 user1-org Development SpaceManager
cf set-space-role user1 user1-org Development SpaceDeveloper
#cf login -a https://api.pcf.issinc.com --skip-ssl-validation

cf create-user user2 user2user2
cf create-org user2-org
cf set-org-role user2 user2-org OrgManager
cf create-space Development -o user2-org
cf set-space-role user2 user2-org Development SpaceManager
cf set-space-role user2 user2-org Development SpaceDeveloper
#cf login -a https://api.pcf.issinc.com --skip-ssl-validation