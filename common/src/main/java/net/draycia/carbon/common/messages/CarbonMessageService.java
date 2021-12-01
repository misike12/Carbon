/*
 * CarbonChat
 *
 * Copyright (c) 2021 Josua Parks (Vicarious)
 *                    Contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package net.draycia.carbon.common.messages;

import java.util.UUID;
import net.draycia.carbon.api.util.RenderedMessage;
import net.draycia.carbon.api.util.SourcedAudience;
import net.draycia.carbon.common.util.ChatType;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.audience.MessageType;
import net.kyori.adventure.text.Component;
import net.kyori.moonshine.annotation.Message;
import net.kyori.moonshine.annotation.Placeholder;

public interface CarbonMessageService {

    @Message("channel.format.basic")
    @ChatType(MessageType.CHAT)
    RenderedMessage basicChatFormat(
        final Audience audience,
        final @Placeholder UUID uuid,
        final @Placeholder("display_name") Component displayName,
        final @Placeholder String username,
        final @Placeholder Component message
    );

    @Message("mute.spy.prefix")
    RenderedMessage muteSpyPrefix(final Audience audience);

    @Message("channel.change")
    void changedChannels(
        final Audience audience,
        final @Placeholder String channel // TODO: allow MiniMessage based channel "names"
    );

    @Message("whisper.to")
    @ChatType(MessageType.CHAT)
    void whisperSender(
        final SourcedAudience audience,
        final @Placeholder("sender_display_name") Component senderDisplayName,
        final @Placeholder("recipient_display_name") Component recipientDisplayName,
        final @Placeholder String message
    );

    @Message("whisper.from")
    @ChatType(MessageType.CHAT)
    void whisperRecipient(
        final SourcedAudience audience,
        final @Placeholder("sender_display_name") Component senderDisplayName,
        final @Placeholder("recipient_display_name") Component recipientDisplayName,
        final @Placeholder String message
    );

    @Message("reply.target.missing")
    void replyTargetNotSet(
        final Audience audience,
        final @Placeholder("sender_display_name") Component senderDisplayName
    );

    @Message("reply.target.self")
    void whisperSelfError(
        final Audience audience,
        final @Placeholder("sender_display_name") Component senderDisplayName
    );

    @Message("continue.target.missing")
    void whisperTargetNotSet(
        final Audience audience,
        final @Placeholder("sender_display_name") Component senderDisplayName
    );

    @Message("nickname.set")
    void nicknameSet(
        final Audience audience,
        final @Placeholder Component nickname
    );

    @Message("nickname.set.others")
    void nicknameSetOthers(
        final Audience audience,
        final @Placeholder String target,
        final @Placeholder Component nickname
    );

    @Message("nickname.show.others")
    void nicknameShowOthers(
        final Audience audience,
        final @Placeholder String target,
        final @Placeholder Component nickname
    );

    @Message("nickname.show.others.unset")
    void nicknameShowOthersUnset(
        final Audience audience,
        final @Placeholder String target
    );

    @Message("nickname.show")
    void nicknameShow(
        final Audience audience,
        final @Placeholder String target,
        final @Placeholder Component nickname
    );

    @Message("nickname.show.unset")
    void nicknameShowUnset(
        final Audience audience,
        final @Placeholder String target
    );

    @Message("nickname.reset")
    void nicknameReset(final Audience audience);

    @Message("nickname.reset.others")
    void nicknameResetOthers(
        final Audience audience,
        final @Placeholder String target
    );

    @Message("mute.exempt")
    void muteExempt(final Audience audience);

    @Message("error.command.no_permission")
    void errorCommandNoPermission(final Audience audience);

    @Message("error.command.command_execution")
    void errorCommandCommandExecution(
        final Audience audience,
        final @Placeholder("throwable_message") Component throwableMessage,
        final @Placeholder String stacktrace
    );

    @Message("error.command.argument_parsing")
    void errorCommandArgumentParsing(final Audience audience, final @Placeholder("throwable_message") Component throwableMessage);

    @Message("error.command.invalid_sender")
    void errorCommandInvalidSender(final Audience audience, final @Placeholder String sender_type);

    @Message("error.command.invalid_syntax")
    void errorCommandInvalidSyntax(final Audience audience, final @Placeholder Component syntax);

    @Message("ignore.exempt")
    void ignoreExempt(final Audience audience, final @Placeholder Component target);

    @Message("ignore.now_ignoring")
    void nowIgnoring(final Audience audience, final @Placeholder Component target);

    @Message("ignore.no_longer_ignoring")
    void noLongerIgnoring(final Audience audience, final @Placeholder Component target);

    @Message("ignore.invalid_target")
    void ignoreTargetInvalid(final Audience audience);

    @Message("whisper.ignoring_target")
    void whisperIgnoringTarget(final Audience audience, final @Placeholder Component target);

    @Message("whisper.ignored_by_target")
    void whisperTargetIgnoring(final Audience audience, final @Placeholder Component target);

    @Message("config.reload.success")
    void configReloaded(final Audience audience);

    @Message("config.reload.failed")
    void configReloadFailed(final Audience audience);

    @Message("muteinfo.self.muted")
    void muteInfoSelfMuted(final Audience audience);

    @Message("muteinfo.self.not_muted")
    void muteInfoSelfNotMuted(final Audience audience);

    @Message("muteinfo.not_muted")
    void muteInfoNotMuted(
        final Audience audience,
        final @Placeholder Component target
    );

    @Message("muteinfo.muted")
    void muteInfoMuted(
        final Audience audience,
        final @Placeholder Component target,
        final @Placeholder boolean muted
    );

    @Message("unmute.alert.target")
    void unmuteAlertRecipient(final Audience audience);

    @Message("unmute.alert.players")
    void unmuteAlertPlayers(final Audience audience, final @Placeholder Component target);

    @Message("mute.alert.target")
    void muteAlertRecipient(final Audience audience);

    @Message("mute.alert.players")
    void muteAlertPlayers(final Audience audience, final @Placeholder Component target);

    @Message("mute.cannot_speak")
    void muteCannotSpeak(final Audience audience);

}
