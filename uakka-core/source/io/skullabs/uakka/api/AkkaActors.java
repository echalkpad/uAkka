package io.skullabs.uakka.api;

import io.skullabs.uakka.api.ActorInfo.CreationInfo;
import io.skullabs.uakka.api.ActorInfo.SearchInfo;
import io.skullabs.uakka.api.exception.InjectionException;

import java.util.Collection;

import akka.actor.ActorRef;
import akka.actor.ActorRefFactory;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;

public interface AkkaActors {

	public abstract void initialize() throws InjectionException;

	public ActorRef actor( CreationInfo creationInfo );

	public abstract ActorRef actor( ActorRefFactory actorRefFactory, CreationInfo creationInfo );

	public abstract ActorRef actor( SearchInfo searchInfo );

	public abstract ActorSelection actor( ActorRefFactory actorRefFactory, SearchInfo searchInfo );

	public abstract void shutdown();

	public abstract void analyze( Collection<Class<?>> classes ) throws InjectionException;

	public ActorSystem getActorSystem();

}