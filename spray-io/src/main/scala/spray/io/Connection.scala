/*
 * Copyright (C) 2011-2012 spray.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package spray.io

import akka.actor.ActorRef


//# source-quote
/**
 * A handle for a network connection.
 */
trait Connection extends IOBridge.Handle {

  /**
   * The IOBridge actor managing the connection.
   */
  def ioBridge: ActorRef

  /**
   * The ActorRef that originally commanded the establishment of this connection.
   * In the case of a client connection the sender of the `Connect` command,
   * in the case of a server connection the sender of the `Bind` command.
   */
  def commander: ActorRef
}
//#

case class DefaultConnection(
  key: IOBridge.Key,
  handler: ActorRef,
  ioBridge: ActorRef,
  commander: ActorRef,
  tag: Any
) extends Connection