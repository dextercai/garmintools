/**
 *    Copyright 2016 Iron City Software LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package garmintools.adapters.proto;

import garmintools.Proto;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class LookupTableProtoAdapter implements ProtoAdapter<List<String>> {
  private final int sectionNumber;

  public LookupTableProtoAdapter(int sectionNumber) {
    this.sectionNumber = sectionNumber;
  }

  @Override
  public List<String> read(Proto.NavigationData proto) {
    for (Proto.StringConstantSection stringConstantSection : proto.getStringConstantSectionList()) {
      if (stringConstantSection.getSectionNumber() == sectionNumber) {
        return ImmutableList.copyOf(stringConstantSection.getConstantList());
      }
    }
    return new ArrayList<>();
  }

  @Override
  public void write(List<String> data, Proto.NavigationData.Builder builder) {
    builder.addStringConstantSectionBuilder().addAllConstant(data).setSectionNumber(sectionNumber);
  }
}
