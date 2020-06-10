select
    /*%expand*/*
from recipes
where
/*%if search != null*/
	name
    Like /* "%" + search "%" + */'a'
/*%end*/
/*%if beforeCal != null*/
	AND
    /*beforeCal*/200 <= cal
/*%end*/
/*%if afterCal != null*/
	AND
    /*afterCal*/0 >= cal
/*%end*/