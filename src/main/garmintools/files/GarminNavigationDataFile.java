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

package garmintools.files;

import garmintools.Proto;
import garmintools.sections.SectionManager;

public class GarminNavigationDataFile {
  private final SectionManager sectionManager;

  GarminNavigationDataFile(SectionManager sectionManager) {
    this.sectionManager = sectionManager;
  }

  public void writeToProto(Proto.NavigationData.Builder protoBuilder) {
    sectionManager.mergeToProto(protoBuilder);
  }

  public void printSections() {
    System.out.println(sectionManager);
  }
}
