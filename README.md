## SpringBoot3 (gradleマルチプロジェクト)の自習用リポジトリ

SpringBoot3 + React (gradleマルチプロジェクト)で、  
SPA + Web APIでのCRUDなWebアプリケーションを作成するための自習用のリポジトリです。  

クライアント側はReactのシングルページアプリケーションで動き、  
アプリケーションはログイン認証機能を持ち、サーバー側はAPIとして受付し、  
DBの操作を行うことができるアプリケーションを構築します。  
誰にでも理解しやすいシンプルなものを構築したいと思います。  

自習が終わった頃には実務でも使えそうな一通りの技術は、何となく使えるようになっているかも。  

#### (扱う技術としては下記を考えています)
Java(JDK17), SpringBoot3, PostgreSQL 15, Gradle, javascript(またはtypescript)  
Node.js(npm, Webpack用),  
html, css, Bootstrap 5(またはTailwind CSS), React 18,

他言語Webフレームワーク、Vue.jsを経験してますが、Java, SpringBoot, Reactはほぼ素人です。  


#### (使用ツール)
Eclipse IDE for Enterprise Java and Web Developers(本家の英語版)  
pgAdmin 4(pgAdminはうまく使えなかったらA5SQL等を使います)  

## (やりたいこと)

#### (全体イメージ)  
![自習アプリ作成の概要](https://user-images.githubusercontent.com/32920703/218566579-a6e46ed3-a721-474e-9ec3-4375717d6227.png)

#### (進め方と課題)  
前提として、EclipseのTerminalでgradle buildが通るか確認しながら進める。  

①Spring DIを利用できるようにする。
Spring DIの利用方法を調査中。

②ORMを選定して、サーバー側のプログラムを一通り実装  
例としてPersonクラスを使用。Entityを直接操作して、独自のRepositoryを作成したいので調査中。  
EntityクラスとModelクラスを分けるべきか検討中。  

データ保存時の作成日時、更新日時の更新、競合チェック処理を追加する。  

③Node.jsのnpmでnode_modulesをインストール、webpackを利用できるようにする  
webpack.config.jsの設定をして、javascriptをモジュールとして使用できるようにする。  
ただし、webpack.config.jsの設定が難しい。  

④SpringBoot上でReactを利用して画面構築する  

React routerで画面切り替えをできるようにする。  
併せて画面デザインにCSSフレームワークを適用し、デザインを整える。(TailwindCSSか、BootStrap5を使用予定)  

⑤ControllerでAPIアクセスが可能か確認  
Controller(RestController)でAPIアクセスが可能か確認する。  

⑥画面からの操作を確認  
画面からサーバー側の処理ができることを確認する。  
Springの例外処理にはAOPの機能を使えると思われるので利用する。  

⑦入力チェックの方法を検討  
サーバー側はSpringBoot標準の何かで実施。  
クライアント側の入力検証をどうするか検討する。model_and_viewの検証値を渡すかも。  

⑧SpringSecurityのログイン認証の動作確認  
SpringSecurityを利用して、ログイン後に、メインメニューへアクセスできる用に修正する。  

⑨セキュリティの動作確認  
各セキュリティ(ログイン認証、入力検証、CSRF対策など)が動作していることを確認する。  

⑩実装の再確認  
④～⑨の実装の再確認。修正をする。  

⑪ユーザー登録処理を実装する。  
ユーザー登録、本人確認、パスワードリマインダー、個人設定の編集、  
管理者権限以上での権限変更の機能を実装する。  

⑫2段階認証の実装  
2段階認証を実装する。  


## 事前のインストール
事前のインストールとして下記を行います。  
Eclipseについては本家の英語版を使用します。  
ほとんどの参考書ではpleiades版Eclipseを使うように指示されてますが、  
プロジェクトエクスプローラーでJavaパッケージが認識されない不具合があったため使用しません。  
(本家の英語版はそのうち慣れるはず)  

バージョンは現時点の最新版を記載します。  

インストーラーの設定については特に変わったことはしなく、標準通りです。  
GitHub Desktopは個人用の設定が必要になります。  

| 項目 | 説明 |
| :--- | :--- |
| Eclipse Adoptium Open JDK 17 | Java開発環境, SpringBootで推奨と思われる。 |
| Apache Tomcat 10 | Http server, Eclipseのデバッグでも使用します。 |
| PostgreSQL 15 | 今回選択したデータベースです。 |
| Eclipse IDE for Enterprise Java and Web Developers 2022 | 開発ツール |
| GitHub Desktop | GitHubに簡単に接続するもの, 今回は初回コミットまたは初回取得をする場合に使用 |
| Gradle 7.6 | SpringBootで使用しているビルドツールです。初回マルチプロジェクトの構築で使用してます。 |
| Node.js 18.13.0 | javascriptライブラリの管理とWebpackを利用するものです。 |

※以下は不具合があったため利用停止(検討中)、バージョン管理は一旦、GitHub Desktopで操作しています。  

| 項目 | 説明 |
| :--- | :--- |
| git 2.39.1| Git本体, Gitのローカルリポジトリ |
| TortoiseGit 2.13 | Gitクライアント, Eclipseの右クリックメニューから使用できるようにします。 |
| TortoiseGit Language Packs(Japan) | TortoiseGitの日本語化。 |

※Gradleはインストーラーでないので、自分で配置して環境変数を設定する必要があります。  

## Eclipseプラグインとして追加するもの
Eclipseのプラグインは下記を追加して下さい。バージョンは現時点の最新版を記載しています。  

| 項目 | 説明 |
| :--- | :--- |
| AnyEdit tools 2.7.2 | Eclipseのエディタ機能を拡張するためのプラグイン。 |
| Autodetect Encoding 1.8.5 | ステータスバーに現在開いているファイルのエンコーディング/改行コードを表示するプラグイン。 |
| Buildship Gradle Integration 3.0 | ビルドシステムであるGradleを利用するにあたって必要なライブラリ類をまとめたプラグイン。 |
| Checkstyle Plug-in 10.4.0 | ソースコードが正しいかどうかを静的解析するプラグイン。 |
| ContextQuickie2 0.6.3 | プロジェクトエクスプローラーでWindowsコンテキスト(右クリックメニュー)を開くプラグイン。TortoiseGitでバージョン管理するために利用します。 |
| EclEmma Java Code Coverage 3.1.6 | コードのテスト網羅率（カバレッジ）を計測するプラグイン。JUnit関連で使用。 |
| Eclipse Enterprise Java and Wed Developer Tools 3.28 | Javaコードのコンパイルや実行、入力補完など、Java開発に欠かせない機能を提供するプラグイン。 |
| Eclipse Zip Editor 1.1.8 | zipファイル内を操作するためのプラグイン。 |
| Enhanced Class Decompiler 3.2.2 | ソースコードがないクラスファイルに対して、Javaコードの確認が行えるプラグイン。 |
| Maven (Java EE) Integration for Eclipse WTP | ※標準でインストールされている |
| SpotBugs Plug-in 3.1.5 | Javaのソースコードを静的解析し、バグを発見するプラグイン。 |
| Spring Tools 4 4.17 | Springフレームワークによるアプリケーション開発をサポートするプラグイン。 |
| Thymeleaf Plugin for Eclipse 3.01 | Springフレームワークによるアプリケーション開発をサポートするプラグイン。 |
| Wide Web Developer HTML, CSS, JSON, Yaml, Javascript, TypeScript, Node tools | ※WDTに含まれるプラグイン。 |

上記に付帯しているプラグインです。  

| 項目 | 説明 |
| :--- | :--- |
| Eclipse JST Server Adapter | ※WDTに含まれるプラグイン。 |
| Eclipse Market Client 1.10.0 | ※標準でインストールされているプラグインを管理するもの。 |
| Eclipse PDE | ※標準でインストールされているプラグイン。 |
| Eclipse Web Developer Tools | ※WDTに含まれるプラグイン。 |
| Mylyn WikiText 3.0 | ※WDTに含まれるプラグイン？ |
| Node.js　embedder from Wild Web Developer | ※WDTに含まれるプラグイン。 |
| TM Terminal | ※WDTに含まれるプラグイン。 |


※lombok.jarはEclipse Marketplaceのプラグインではないが、Eclipseインストール時に含まれる。  
なければ追加してください。  
※EGitはGradleと相性が悪いのでアンインストールします。  
※何か作業した時に余計なプラグインが追加されることがあります。不要なものは削除して下さい。  

## Eclipse設定
Adoptium Open JDKは初期状態で設定済みと思います。  
EclipseのデバッグでWebアプリを動かすために、Apache Tomcatの設定が必要です。  
EclipseでServersのタブを表示させて、そこにApache Tomcatのパスを設定します。  

Projectについては、このリポジトリからダウンロード可能です。  

→ 自前で準備しない場合(リンク先を準備中)  


## PostgreSQL設定  

Eclipseデバッグ実行時にコンソールで文字化けするので対策のため、  
postgresの「C:\Program Files\PostgreSQL\15\data/postgresql.conf」を修正します。  

```postgresql.conf
/# lc_messages = 'Japanese_Japan.932'
lc_messages = 'en_US'
```

変更後はサービスを再起動します。  

SpringBootで使用するデータベースを準備します。  

#### (データベース作成)
```SQL
-- Create database
CREATE DATABASE test_db;
```

#### (テーブル作成と、テストデータ追加)
postgresql_schema.sqlのSQLを利用してテーブル追加  

postgresql_data.sqlのSQLを利用してデータ追加  

## user_interfaceプロジェクトのDB接続準備
SpringBootを実行するためにDB接続設定が必要なため、   
user_interfaceプロジェクトのapplication.propertiesを編集します。  
ローカルPCのPostgreSQLに合わせた設定をして下さい。  

設定が正しくないとSpringBootは起動できません。(わかりにくいエラーが出ます)  

```application.properties
# Spring database configuration
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/test_db
spring.datasource.username=postgres
spring.datasource.password=xxxx
```

## GitHubの利用
一番簡単な方法として、GitHubへの接続にはGitHub Desktopを使用することが可能です。  

TortoiseGitを使うこともできるようですが、挙動がおかしかったため利用を一旦中止します。  
リモートリポジトリからデータを取得する時にgradleプロジェクトが認識されませんでした。  
メモとして「git_tortoisegit設定.txt」に記載します。  

## 正しく準備できた場合のEclipse

user_interfaceプロジェクトをクリックして、デバッグ → Spring Boot Appを実行します。  
<img src="https://user-images.githubusercontent.com/32920703/216080186-b5bf68ad-f145-4b12-8897-d800af546416.png" width="50%">

「http://localhost:8080」 を開くとログイン画面が表示されます。  

※現在はデフォルトのログイン画面は表示されず、独自のログイン画面(デザイン未修正)と、  
データベース問い合わせに変更しています。  


## Gradle build
EclipseのTerminalでgradle buildを実行し、ビルドが通るか確認しながら進めて下さい。


## 注意事項
・画面がおかしいときはEclipseを再起動しないと反映しない場合がある。  

・プロジェクトエクスプローラーや、フォルダの直接操作で、フォルダ名を変更すると不具合が出るためしないで下さい。  
フォルダは常に新規作成、または削除で対応して下さい。


## SpringBootプロジェクトでのNode.jsのnpm利用方法。
調査中。  

