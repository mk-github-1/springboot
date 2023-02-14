// webpack.config.jsは下書きです。

// https://zenn.dev/hrkmtsmt/articles/93653309e2a13d

const path = require('path');

module.exports = {
	// バンドルするファイルに影響するプロパティ。
	mode: 'development',

	// どのファイルを起点にバンドルするかを設定するプロパティ。
  	entry: './src/index.tsx',

  	//　どのディレクトリにバンドルしたファイルを出力するかを設定するプロパティ。
  	output: {
    	path: path.join(__dirname, 'dist'),
    	filename: 'main.js',
  	},

  	//　babel-loaderやcss-loaderといった Loader の設定を行うプロパティ。
  	module: {
    	rules: [
      		{
        		test: /\.(ts|tsx)$/,
        		use: [
          			{
            			loader: 'babel-loader',
            			options: { presets: ['@babel/preset-env', '@babel/react'] },
          			},
          			{
            			loader: 'ts-loader',
            			options: {
              				configFile: path.resolve(__dirname, 'tsconfig.json'),
            			},
          			},
        		],
      		},
      		{
        		test: /\.scss$/,
        		use: ['style-loader', 'css-loader', 'sass-loader']
      		},
    	],
  	},

  	// webpack-dev-serverの設定を行うプロパティ。
  	devServer: {
    	static: {
      		directory: path.join(__dirname, 'dist'),
    	},
    	port: 3000,
  	},

  	// インポート時にのパスの問題(絶対パスや相対パス)を解決するプロパティ。
  	resolve: {
    	extensions: ['.ts', '.tsx', '.js', '.json'],
  	},

    // サーバー側(Node.js)とブラウザ側(フロント)どちらにコンパイルするかを設定するプロパティ。
	target: 'web',
};