select
    /*%expand*/*
from recipes
where
/*%if beforeCal == null && afterCal == null*/
AND name
	Like /* "%" + search "%" + */'a'
/*%elseif search != null && beforeCal != null && afterCal != null*/	
	AND name
	Like /* "%" + search "%" + */'a'
	AND
	/*afterCal*/0 >= cal
	AND 
	/*beforeCal*/0 <= cal	
/*%elseif beforeCal == null*/
	AND
	/*afterCal*/0 >= cal	
/*%elseif afterCal == null*/
	AND 
	/*beforeCal*/0 <= cal
/*%end*/
AND name
Like /* "%" + search "%" + */'a'

