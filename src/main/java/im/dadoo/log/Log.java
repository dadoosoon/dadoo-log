/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.log;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 *
 * @author codekitten
 */
public class Log implements Serializable {
  
  protected String id;
  
  protected String serviceName;
  
  protected String type;
  
  protected Long createDatetime;
  
  protected Long saveDatetime;
  
  protected Map<String, Object> content;

  public Log() {}
  
  public Log(String serviceName, String type, Long createDatetime, Map<String, Object> content) {
    this.serviceName = serviceName;
    this.type = type;
    this.createDatetime = createDatetime;
    this.content = content;
    this.saveDatetime = null;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    sb.append("id:").append(getId()).append(",");
    sb.append("serviceName:").append(getServiceName()).append(",");
    sb.append("type:").append(getType()).append(",");
    if (getSaveDatetime() != null) {
      sb.append("saveDatetime:").append(
            DateFormatUtils.ISO_DATETIME_FORMAT.format(getSaveDatetime())).append(",");
    }
    sb.append("createDatetime:").append(
            DateFormatUtils.ISO_DATETIME_FORMAT.format(getCreateDatetime())).append(",");
    sb.append("content:").append(getContent());
    sb.append("}");
    return sb.toString();
  }
  
  public String toPropertyString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    sb.append("id:").append(getId()).append(",");
    sb.append("serviceName:").append(getServiceName()).append(",");
    sb.append("type:").append(getType()).append(",");
    if (getSaveDatetime() != null) {
      sb.append("saveDatetime:").append(
            DateFormatUtils.ISO_DATETIME_FORMAT.format(getSaveDatetime())).append(",");
    }
    sb.append("createDatetime:").append(
            DateFormatUtils.ISO_DATETIME_FORMAT.format(getCreateDatetime()));
    sb.append("}");
    return sb.toString();
  }
  
  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }
  
  /**
   * @return the serviceName
   */
  public String getServiceName() {
    return serviceName;
  }

  /**
   * @param serviceName the serviceName to set
   */
  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the createDatetime
   */
  public Long getCreateDatetime() {
    return createDatetime;
  }

  /**
   * @param createDatetime the createDatetime to set
   */
  public void setCreateDatetime(Long createDatetime) {
    this.createDatetime = createDatetime;
  }

  /**
   * @return the content
   */
  public Map<String, Object> getContent() {
    return content;
  }

  /**
   * @param content the content to set
   */
  public void setContent(Map<String, Object> content) {
    this.content = content;
  }

  /**
   * @return the saveDatetime
   */
  public Long getSaveDatetime() {
    return saveDatetime;
  }

  /**
   * @param saveDatetime the saveDatetime to set
   */
  public void setSaveDatetime(Long saveDatetime) {
    this.saveDatetime = saveDatetime;
  }
 
}
