# GrassPlayer

## 使い方
* GrassPlayerの取得

|メソッド|説明|
|:-:|:-:|
|static GrassPlayer#get(Player)|GrassPlayerを返す|
|static GrassPlayer#get(String)|UUIDからGrassPlayerを返す|

* 利用できるメソッド

|メソッド|返り値|説明|
|:-:|:-:|:-:|
|~~save()~~|boolean|GrassPlayerのデータを保存する 成功するとtrueを返し その他の場合にはfalseを返す|
|toPlayer()|Player|GrassPlayerからPlayerを返す|
|getStamina()|int|スタミナを返す|
|getEffectiveStamina()|int|スタミナの有効値を返す|
|getMaxStamina()|int|スタミナの最大値を返す|
|incrementStamina(int)|int|スタミナを引数値分加算する|
|setStamina(int)|void|スタミナを引数に与えられた値に変更する 有効値を超過した場合は有効値に 0未満の場合は0になる|
|setEffectiveStamina(int)|void|スタミナの有効値を引数に与えられた値に変更する 最大値を超過した場合は最大値に 0未満の場合は0になる|
|setMaxStamina(int)|void|スタミナの最大値を引数に与えられた値に変更する 0未満の場合は0になる|