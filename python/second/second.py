from sqlalchemy import create_engine
import tushare as ts
ts.set_token("14cf327c88cf8fc8b37a65d3ee08d17070e9092249eb6a688312f996");
pro = ts.pro_api();
df = ts.pro_bar(pro_api=pro, ts_code='000001.SZ', adj='qfq', start_date='20180121', end_date='20181221',ma=[5,10,30,60])

print(df);

#database = create_engine('mysql://root:rootroot@127.0.0.1/TESTDB?charset=utf8')
#df.to_sql('test',database)
df.to_csv('2.csv')