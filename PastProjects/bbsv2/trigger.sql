
create trigger insert_reply
before insert 
on reply
for each row
  begin
IF(:old.type='T')
then update topic set lastreplytime=:old.creratetime where topicid=:old.parentid;
  end if;
  end;
  
  
create trigger update_reply
before update 
on reply
for each row
  begin
IF(:new.type='T')
then update topic set lastreplytime=:new.modifytime where topicid=:new.parentid;
  end if;
  end;
