CREATE TABLE IF NOT EXISTS datasource (
  id INT AUTO_INCREMENT PRIMARY KEY COMMENT '数据源 ID',
  name VARCHAR(16) COMMENT '数据源编码名',
  show_name VARCHAR(255) COMMENT '数据源名词',
  username VARCHAR(255) COMMENT '用户名',
  password VARCHAR(255) COMMENT '密码',
  source_type VARCHAR(16) COMMENT '数据源类型',
  connection_url VARCHAR(1024) COMMENT '连接 URL',
  description varchar(2048) COMMENT '描述信息',
  created_by VARCHAR(64) COMMENT '创建人',
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_by VARCHAR(64) COMMENT '更新人',
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS dataset (
  id INT AUTO_INCREMENT PRIMARY KEY COMMENT '数据集 ID',
  name VARCHAR(255) COMMENT '数据集名称',
  show_name VARCHAR(255) COMMENT '展示名称',
  description varchar(2048) COMMENT '描述信息',
  datasource_id INT COMMENT '数据源 ID',
  created_by VARCHAR(64) COMMENT '创建人',
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_by VARCHAR(64) COMMENT '更新人',
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS column_info (
  id INT AUTO_INCREMENT PRIMARY KEY COMMENT '列信息 ID',
  name VARCHAR(255) COMMENT '列名',
  show_name VARCHAR(255) COMMENT '展示名称',
  description varchar(1024) COMMENT '描述信息',
  data_type VARCHAR(32) COMMENT '数据类型',
  dataset_id INT COMMENT '数据集 ID',
  created_by VARCHAR(64) COMMENT '创建人',
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_by VARCHAR(64) COMMENT '更新人',
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
