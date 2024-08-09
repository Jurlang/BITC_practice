async function getAbyss(characterName) {
    let basicURL = "https://developer-lostark.game.onstove.com/gamecontents/challenge-abyss-dungeons"
    const result = await axios.get(basicURL, {
        headers: {
            Authorization: `Bearer ${accessToken}`
        }
    });
    return result.data;
}

async function getGuardian(characterName) {
    let basicURL = "https://developer-lostark.game.onstove.com/gamecontents/challenge-guardian-raids"
    const result = await axios.get(basicURL, {
        headers: {
            Authorization: `Bearer ${accessToken}`
        }
    });
    return result.data;
}