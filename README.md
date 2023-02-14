## SpringBoot3 (gradleマルチプロジェクト)の自習用リポジトリ

SpringBoot3 + React (gradleマルチプロジェクト)で、  
SPA + Web APIでのCRUDなWebアプリケーションを作成するための自習用のリポジトリです。  

クライアント側はReactのシングルページアプリケーション(javascript管理下)で動き、  
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
![自習アプリ作成の概要](https://user-images.githubusercontent.com/32920703/218778468-d0df6e7e-dd67-4ebc-9114-6b9c745dd639.png)


#### (進め方と課題)  
前提として、EclipseのTerminalで、cdでプロジェクトのルートフォルダに移動し、  
gradle buildが通るか確認しながら進める。  
※このGitHubには.classpass等の個人PCによって影響があるものは除外してコードを載せています。

①直近で実現したいこと **************************************************  
ここでは例としてPersonクラスを使用し、下記を優先で実施します。  

・PersonController, PersonServiceでSpring DIを利用できるようにする。  
・ORMはHibernateなど何かを利用するが、デフォルトのRepositoryは使用せず、Entityを直接操作する独自のRepositoryを作成する。  
・EntityクラスとModelクラスを分けるべきか検討中。  
・サーバー側のプログラムを一通り実装する。AOPによる例外処理も追加する。  
・indexからPersonControllerにAPIアクセスする。  ※この時点ではPersonのhtmlをサーバーサイドレンダリングしてよい。  
・データ保存時の作成日時、更新日時の更新、競合チェック処理を追加する。  

※SpringSecutiryが邪魔するかもしれないので一旦OFFにしておいてもOK。

　**************************************************  

②Node.jsのnpmでnode_modulesをインストール、webpackを利用できるようにする  
webpack.config.jsの設定をして、javascriptをモジュールとして使用できるようにする。  
ただし、webpack.config.jsの設定が難しい。  

③SpringBoot上でReactを利用して画面構築する。  
メインはindex.htmlの共通フレームとして利用、React routerで画面切り替えをできるようにする。  
併せて画面デザインにCSSフレームワークを適用し、デザインを整える。(TailwindCSSか、BootStrap5を使用予定)  

④入力チェックの方法を検討  
サーバー側： SpringBoot標準の何か？　クライアント側： model_and_viewの入力検証を渡して独自実装。  
クライアント側の実装はできるが、model_and_viewの入力検証をどのように渡すか調査

⑤SpringSecurityのログイン認証の動作確認  
SpringSecurityを利用して、ログイン後に、HomeControllerでindex.htmlを描画  
React routerでHomeからPersonへ画面遷移させる。  

⑥セキュリティの動作確認  
各セキュリティ(ログイン認証、入力検証、CSRF対策など)が動作していることを確認する。  

⑦ユーザー登録処理を実装する。  
ユーザー登録、本人確認、パスワードリマインダー、個人設定の編集、  
管理者権限以上での権限変更の機能を実装する。  

⑧2段階認証の実装  
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

※Gradleはインストーラーでないので、自分で配置して環境変数を設定する必要があります。  
※TortoiseGitの利用を検討していましたが一旦保留にしてます。現在、GitHubの更新にはGitHub Desktopで操作しています。  

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
| Wide Web Developer HTML, CSS, JSON, Yaml, Javascript, TypeScript, Node tools | ※WDTに含まれるプラグイン。 |

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

「http://localhost:8080」 を開くとログイン画面が表示されます。  

※現在はデフォルトのログイン画面は表示されず、独自のログイン画面(デザイン未修正)と、  
データベース問い合わせに変更しています。  


## Gradle build
EclipseのTerminalで、cdでプロジェクトのルートフォルダに移動し、  
gradle buildを実行し、ビルドが通るか確認しながら進めて下さい。  


#### (注意事項)
・画面がおかしい時はEclipseを再起動しないと反映しない場合がある。  

・プロジェクトエクスプローラーでは、パッケージフォルダは常に新規作成、または削除で対応する必要があります。  
フォルダ名を変更すると不具合が出るため、フォルダ名変更の操作はしないで下さい。  


## SpringBootプロジェクトでのNode.jsのnpm利用方法。
調査中。  

## webpack.config.jsについて
ソースにあるものは下書きです。調査中。  
