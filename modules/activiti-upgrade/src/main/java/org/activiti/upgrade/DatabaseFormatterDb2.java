/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.upgrade;

import java.util.Date;


public class DatabaseFormatterDb2 extends DatabaseFormatter {

  @Override
  public String formatBinary(byte[] bytes) {
    StringBuffer sb = new StringBuffer();
    sb.append("blob(X'");
    appendBytesInHex(sb, bytes);
    sb.append("')");
    return sb.toString();
  }

  @Override
  public String formatBoolean(boolean b) {
    return (b ? "1" : "0");
  }

  @Override
  public String formatDate(Date date) {
    StringBuffer sb = new StringBuffer();
    sb.append("TIMESTAMP (");
    sb.append(defaultDateFormat.format(date));
    sb.append(")");
    return sb.toString();
  }
}
