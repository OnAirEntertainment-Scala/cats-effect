/*
 * Copyright 2020-2021 Typelevel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cats.effect
package std

class EnvSpec extends BaseSpec {

  "Env" should {
    "retrieve a variable from the environment" in real {
      Env[IO].get("HOME").flatMap(x => IO(x must beSome))
    }
    "return none for non-existent environment variable" in real {
      Env[IO].get("MADE_THIS_UP").flatMap(x => IO(x must beNone))
    }
    "create a map of all the things" in real {
      Env[IO].toMap.flatMap(x => IO(x must not(beEmpty)))
    }
  }

}
