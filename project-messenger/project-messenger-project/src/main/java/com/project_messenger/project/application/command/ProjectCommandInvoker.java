package com.project_messenger.project.application.command;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import net.evdut.cqrs.framework.command.CommandInvoker;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProjectCommandInvoker extends CommandInvoker {	

}
