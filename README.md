# LobbyFlyPlugin
ロビーサーバーで空を飛ぶことができるようになるプラグイン。<br>
Spigot1.8.8で動作します。(他バージョンも対応してるとは思います。)<br>
飛行機能以外にもログイン時にワールドスポーンに毎回tpするような機能もあります。<br>
[English Description & Spigot Page is here！](https://www.spigotmc.org/resources/lobbyflyplugin.123217/)<br>

## 導入方法
1. `plugins`フォルダーにjarファイルを入れる。
2. サーバーを起動する。

## 使い方
1. 空を飛ぶプレイヤーに`lobbyflyplugin.fly`の権限を付与。
2. `/fly`で飛行モードを切り替えれます。

## コマンド一覧
* `/fly` 飛行モードを切り替えます。
* `/flymanage` 管理者用コマンドです。
  * `reload` Configをリロードします。

## 権限一覧
* `lobbyflyplugin.fly` 飛行、飛行モードの切り替えを行うための権限です。
* `lobbyflyplugin.flymanage` Plugin管理者用の権限です。

## Config
* `join-fly` ログイン時に飛行した状態にするかどうか
* `disable-fall-damage` 落下ダメージを無効化するかどうか
* `disable-all-damage` 全てのダメージを無効化するかどうか
* `join-tp-spawn` ログイン時にスポーン地点にtpするかどうか
* `horizon-limit` ロビーの外側にいけないようにするかどうか
* `back-from-void` 奈落に落ちた際にスポーン地点に戻るかどうか
